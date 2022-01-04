package com.yunlan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yunlan.controller.vo.GoodsVO;
import com.yunlan.dao.CommentMapper;
import com.yunlan.dao.OrderItemMapper;
import com.yunlan.dao.UserMapper;
import com.yunlan.model.Comment;
import com.yunlan.model.GoodsInfo;
import com.yunlan.dao.GoodsInfoMapper;
import com.yunlan.model.OrderItem;
import com.yunlan.result.R;
import com.yunlan.service.GoodsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-12-30
 */



@Service
public class GoodsInfoServiceImpl extends ServiceImpl<GoodsInfoMapper, GoodsInfo> implements GoodsInfoService {
    @Autowired
    private  GoodsInfoMapper goodsInfoMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public R getAllGoods(){

        List<GoodsInfo> goodsInfoList =goodsInfoMapper.selectList(null);

        List<GoodsVO> goodsVOList=new ArrayList<>();
        for (GoodsInfo goodsInfo:goodsInfoList){
            GoodsVO goodsVO=new GoodsVO();
            BeanUtils.copyProperties(goodsInfo,goodsVO);
            goodsVO.setStoreName(goodsInfoMapper.selectStoreNameById(goodsInfo.getStoreId()));
            goodsVOList.add(goodsVO);
        }
        return new R(true,"获取商品信息成功",goodsVOList);
    }
    //获取分类商品接口
    @Override
    public R getGoodsById(Long id){
        List<GoodsInfo> goodsInfoList =goodsInfoMapper.selectList(new QueryWrapper<GoodsInfo>().eq("goods_category_id",id));
        List<GoodsVO> goodsVOList=new ArrayList<>();
        for (GoodsInfo goodsInfo:goodsInfoList){
            GoodsVO goodsVO=new GoodsVO();
            BeanUtils.copyProperties(goodsInfo,goodsVO);
            goodsVO.setStoreName(goodsInfoMapper.selectStoreNameById(goodsInfo.getStoreId()));
            goodsVOList.add(goodsVO);
        }

        return new R(true,"获取商品信息成功",goodsVOList);
    }


    @Override
    public R getGoodById(Long id){
        GoodsVO goodsVO=new GoodsVO();
        GoodsInfo goodsInfo=goodsInfoMapper.selectById(id);
        BeanUtils.copyProperties(goodsInfo,goodsVO);
        goodsVO.setStoreName(goodsInfoMapper.selectStoreNameById(goodsInfo.getStoreId()));
        return new R(true,"获取商品信息成功",goodsVO);
    }

    @Override
    public R searchGoodsByName(String goodName){
        if (goodName==""){
            return new R(true,"请输入商品名");
        }
        List<GoodsInfo> goodsInfos=goodsInfoMapper.selectList(new QueryWrapper<GoodsInfo>()
                .like("goods_name ",goodName));
        if (goodsInfos.size()==0){
            return new R(true,"暂时没有这件商品");
        }
        List<GoodsVO> goodsVOList=new ArrayList<>();
        for (GoodsInfo goodsInfo:goodsInfos){
            GoodsVO goodsVO=new GoodsVO();
            BeanUtils.copyProperties(goodsInfo,goodsVO);
            goodsVO.setStoreName(goodsInfoMapper.selectStoreNameById(goodsInfo.getStoreId()));
            goodsVOList.add(goodsVO);
        }
        return new R(true,"获取商品信息成功",goodsVOList);

    }

    @Override
    public R getCommentById(long goodId){
        return new R(true,"查询成功",commentMapper.selectList(new QueryWrapper<Comment>()
                .eq("goods_id",goodId)));
    }


    @Override
    public R addComment(Integer orderId,String cmt){

        try {
            OrderItem order=orderItemMapper.selectById(orderId);
            Comment comment=new Comment();
            BeanUtils.copyProperties(order,comment,"createTime");
            comment.setComment(cmt);
            comment.setLoginName(userMapper.selectById(comment.getUserId()).getLoginName());

            commentMapper.insert(comment);
        }catch (Exception e){
            e.printStackTrace();
            return new R(false,"添加评论失败");
        }

        return new R(true,"添加评论成功");
    }
}