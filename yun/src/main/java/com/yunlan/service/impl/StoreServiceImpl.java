package com.yunlan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yunlan.controller.form.StoreRegisterForm;
import com.yunlan.controller.form.UploadGoodForm;
import com.yunlan.controller.vo.GoodsVO;
import com.yunlan.controller.vo.OrderVO;
import com.yunlan.controller.vo.StoreVO;
import com.yunlan.dao.GoodsInfoMapper;
import com.yunlan.dao.OrderItemMapper;
import com.yunlan.dao.UserMapper;
import com.yunlan.model.GoodsInfo;
import com.yunlan.model.OrderItem;
import com.yunlan.model.Store;
import com.yunlan.dao.StoreMapper;
import com.yunlan.result.R;
import com.yunlan.service.StoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {
    @Data
    private class S{

        public  S(long storeId){
            this.storeId=storeId;
        }
        /**
         * 商家主键id
         */
        private Long storeId;
    }
    @Value("${file-save-path}")
    private String dataPath;

    @Autowired
    private  GoodsInfoMapper goodsInfoMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StoreMapper storeMapper;
    @Override
    public R getAllGoodsByStoreId(Integer storeId){
        try {
            List<GoodsInfo> goodsInfoList =goodsInfoMapper.selectList(new QueryWrapper<GoodsInfo>()
                    .eq("store_id",storeId));
            List<GoodsVO> goodsVOList=new ArrayList<>();
            for (GoodsInfo goodsInfo:goodsInfoList){
                GoodsVO goodsVO=new GoodsVO();
                BeanUtils.copyProperties(goodsInfo,goodsVO);
                goodsVO.setStoreName(goodsInfoMapper.selectStoreNameById(goodsInfo.getStoreId()));
                goodsVOList.add(goodsVO);
            }
            return new R(true,"获取商品信息成功",goodsVOList);
        } catch (BeansException e) {
            e.printStackTrace();
            return new R(false,"获取商品信息失败");
        }
    }

    @Override
    public R isStore(Integer userId){
        Store store=storeMapper.selectOne(new QueryWrapper<Store>()
                .eq("user_id",userId));
        if (store==null){
            return new R(false,"用户还没有开通商铺,请先注册");
        }
        StoreVO storeVO=new StoreVO();
        BeanUtils.copyProperties(store,storeVO);

        return new R(true,"用户已开通商铺",storeVO);
    }

    @Override
    public R registerStore(StoreRegisterForm storeRegisterForm){
        Store store=storeMapper.selectOne(new QueryWrapper<Store>()
                .eq("user_id",storeRegisterForm.getUserId()));
        if (store!=null){
            return  new R(false,"该用户已经注册了店铺");
        }
        store=new Store();
        BeanUtils.copyProperties(storeRegisterForm,store);
        storeMapper.insert(store);
        return  new R(true,"注册店铺成功",new S(store.getStoreId()));
    }

    @Override
    public R getAllOrdersByStoreId(Integer storeId){
        List<String> goodList=storeMapper.selectGoodIds(storeId);
        if (goodList.size()==0){
            return new R(true,"暂时没有订单");
        }
        List<OrderItem> orderItemList = orderItemMapper.selectList(new QueryWrapper<OrderItem>()
                .in("goods_id",goodList));
        List<OrderVO> orderItemVOList=new ArrayList<>();
        for (OrderItem orderItem:orderItemList){
            OrderVO orderVO = new OrderVO();
            BeanUtils.copyProperties(orderItem, orderVO);
            orderVO.setGoodsCoverImg(goodsInfoMapper.selectUrlById(orderItem.getGoodsId()));
            orderVO.setCategoryId(orderItemMapper.selectCategoryIdByGoodId(orderItem.getGoodsId()));
            orderVO.setLoginName(userMapper.selectById(orderVO.getUserId()).getLoginName());
            orderItemVOList.add(orderVO);
        }
        return new R(true,"获取订单信息成功",orderItemVOList);
    }

    @Override
    public R uploadGood(MultipartFile file, UploadGoodForm uploadGoodForm){
        if (file.isEmpty()) {
            return new R(false,"文件上传失败");
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //生成文件名称通用方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(dataPath+newFileName);
            Files.write(path, bytes);

            //插入数据
            GoodsInfo goodsInfo=new GoodsInfo();
            BeanUtils.copyProperties(uploadGoodForm,goodsInfo);
            goodsInfo.setGoodsCoverImg("/img/"+newFileName);
            goodsInfo.setOriginalPrice(goodsInfo.getSellingPrice());
            goodsInfoMapper.insert(goodsInfo);

        } catch (IOException e) {
            e.printStackTrace();
            return new R(false,"文件上传失败");
        }



        return new R(true,"商品上传成功");
    }


}

