# API文档
## Basic Response Body

序号  |参数|类型|规则
---- | -----| -----|-----
1|flag|bool|true或flase
2|msg|string|{...}
3|data|object|实例或null

## 注册

- URL：/user/register

- method:post

- Request querystring

    ```
    loginName:123456 //电话
    nickName:金琦  //名称
    password:123456  //密码
    ```

- Response Body

        {
          "data": {},
          "msg": "请求成功",
          "flag": true
        }



# 2.登录

- URL：/user/login

- method:post

- Request querystring

  ```
  loginName:123456 //电话
  password:123456  //密码
  ```

- Response Body

  ```
  {
      "flag": true,
      "data": {
          "name": "11234567890",
          "userId": "13"
      },
      "msg": "登录成功"
  }
  ```

#   商品相关接口

## 获取商品分类

- URL：/categories

- method:get

- Request querystring

  ```
  
  ```

- Response Body

  ```json
  {
      "flag": true,
      "data": [
          {
              "categoryId": 15,
              "categoryName": "丹药"
          },
          {
              "categoryId": 16,
              "categoryName": "炼丹炉"
          },
          {
              "categoryId": 17,
              "categoryName": "功法"
          },
          {
              "categoryId": 18,
              "categoryName": "数码"
          },
          {
              "categoryId": 19,
              "categoryName": "手机"
          },
          {
              "categoryId": 20,
              "categoryName": "生活电器"
          }
      ],
      "msg": "查询成功"
  }
  ```

## 获取所有商品

- URL：/goods

- method:get

- Request querystring

  ```
  
  ```

- Response Body

  ```json
  {
      "flag": true,
      "data": [
          {
              "goodsId": 1,
              "goodsName": "大还丹",
              "goodsIntro": "活死人肉白骨",
              "goodsCategoryId": 15,
              "goodsCoverImg": "/admin/dist/img/no-img.png",
              "goodsDetailContent": "一种神奇的丹药，可以使服用者即刻治愈身体上的伤，由于药效强劲，甚至被人称为可以将死人复活。",
              "originalPrice": 999,
              "sellingPrice": 999,
              "stockNum": 100,
              "storeName": "万药阁"
          },
          {
              "goodsId": 2,
              "goodsName": "天鼎",
              "goodsIntro": "世界上最强劲的药鼎",
              "goodsCategoryId": 16,
              "goodsCoverImg": "/admin/dist/img/no-img.png",
              "goodsDetailContent": "被誉为世界上最强劲的药鼎，可以使炼药者在炼药的过程中事半功倍，极大地发挥所用药材的效用，物尽其用。",
              "originalPrice": 1000,
              "sellingPrice": 888,
              "stockNum": 10,
              "storeName": "地摊"
          }
      ],
      "msg": "查询成功"
  }
  ```

## 根据分类id获取商品

- URL：/goodsByCategoryId

- method:get

- Request querystring

  ```
  goodsCategoryId:15
  ```

- Response Body

  ```json
  {
      "flag": true,
      "data": [
          {
              "goodsId": 1,
              "goodsName": "大还丹",
              "goodsIntro": "活死人肉白骨",
              "goodsCategoryId": 15,
              "goodsCoverImg": "/admin/dist/img/no-img.png",
              "goodsDetailContent": "一种神奇的丹药，可以使服用者即刻治愈身体上的伤，由于药效强劲，甚至被人称为可以将死人复活。",
              "originalPrice": 999,
              "sellingPrice": 999,
              "stockNum": 100,
              "storeName": "万药阁"
          },
          {
              "goodsId": 2,
              "goodsName": "天鼎",
              "goodsIntro": "世界上最强劲的药鼎",
              "goodsCategoryId": 16,
              "goodsCoverImg": "/admin/dist/img/no-img.png",
              "goodsDetailContent": "被誉为世界上最强劲的药鼎，可以使炼药者在炼药的过程中事半功倍，极大地发挥所用药材的效用，物尽其用。",
              "originalPrice": 1000,
              "sellingPrice": 888,
              "stockNum": 10,
              "storeName": "地摊"
          }
      ],
      "msg": "查询成功"
  }
  ```

## 获取单个商品详情信息

- URL：/goodById

- method:get

- Request querystring

  ```
  goodsId:5
  ```

- Response Body

  ```json
  {
      "flag": true,
      "data": {
          "goodsId": 5,
          "goodsName": "驻颜丹",
          "goodsIntro": "可以持久性地保持当前的容貌，颇受年轻女性喜爱",
          "goodsCategoryId": 15,
          "goodsCoverImg": "/admin/dist/img/no-img.png",
          "goodsDetailContent": "驻颜丹，可以使人容颜不老",
          "originalPrice": 999,
          "sellingPrice": 99,
          "stockNum": 10,
          "storeName": "万药阁"
      },
      "msg": "获取商品信息成功"
  }
  
  ```
  
  

# 获取用户购物车

## 获取购物车的所有商品

- URL：/shoppingCart

- method:get

- Request querystring

  ```
  userId:13
  ```

- Response Body

  ```json
  {
      "flag": true,
      "data": [
          {
              "goodsId": 6,
              "goodsName": "还元丹",
              "goodsIntro": "一种治疗内伤的丹药",
              "goodsCategoryId": 15,
              "goodsCoverImg": "/img/2.01f43ae1.png",
              "goodsDetailContent": "好神奇的丹药",
              "originalPrice": 1,
              "sellingPrice": 1,
              "stockNum": 10,
              "storeName": null,
              "cartItemId": 4,
              "userId": 13,
              "goodsCount": 1
          },
          {
              "goodsId": 7,
              "goodsName": "反命丹",
              "goodsIntro": "吃了会反命",
              "goodsCategoryId": 15,
              "goodsCoverImg": "/img/2.01f43ae1.png",
              "goodsDetailContent": "真的好神奇的丹药",
              "originalPrice": 1,
              "sellingPrice": 1,
              "stockNum": 10,
              "storeName": null,
              "cartItemId": 5,
              "userId": 13,
              "goodsCount": 1
          },
          {
              "goodsId": 9,
              "goodsName": "培元丹",
              "goodsIntro": "吃了会培元",
              "goodsCategoryId": 15,
              "goodsCoverImg": "/img/2.01f43ae1.png",
              "goodsDetailContent": "买到就是赚到",
              "originalPrice": 1,
              "sellingPrice": 1,
              "stockNum": 10,
              "storeName": null,
              "cartItemId": 6,
              "userId": 13,
              "goodsCount": 1
          }
      ],
      "msg": "获取商品信息成功"
  }
  
  ```

  

## 添加商品到购物车

- URL：/shoppingCart/addGood

- method:post

- Request querystring

  ```
  userId:13
  GoodsId:1
  ```

- Response Body

  ```json
  {
      "flag": true,
      "data": null,
      "msg": "添加成功"
  }
  ```

  

## 从购物车删除商品

- URL：/shoppingCart/delGood

- method:post

- Request querystring

  ```
  cartItemId:9
  ```

- Response Body

  ```json
  {
      "flag": true,
      "data": null,
      "msg": "删除成功"
  }
  ```

## 更新商品数量

- URL：/shoppingCart/delGood

- method:post

- Request querystring

  ```
  cartItemId:9
  ```

- Response Body

  ```json
  {
      "flag": true,
      "data": null,
      "msg": "删除成功"
  }
  ```

  

## 查询所有订单

- URL：/orders

- method:get

- Request querystring

  ```
  userId:13
  ```

- Response Body

  ```json
  {
      "flag": true,
      "data": [
          {
              "orderItemId": 1,
              "goodsId": 1,
              "goodsName": "大还丹",
              "categoryId": 15,
              "goodsCoverImg": "/img/huanyuandan.jpg",
              "sellingPrice": 999,
              "goodsCount": 10,
              "createTime": "2021-12-29T17:22:37",
              "orderStatus": 0
          },
          {
              "orderItemId": 2,
              "goodsId": 2,
              "goodsName": "天鼎",
              "categoryId": 16,
              "goodsCoverImg": "/img/WSD.a3fad85b.png",
              "sellingPrice": 1000,
              "goodsCount": 1,
              "createTime": "2021-12-29T17:22:37",
              "orderStatus": 0
          }
      ],
      "msg": "获取订单信息成功"
  }
  ```
  
  

## 添加订单(添加成功后会删除购物车相关信息)

- URL：/addOrders

- method:post

- Request querystring

  ```
  userId:13
  cartItemId:5
  ```

- Response Body

  ```json
  {
      "flag": true,
      "data": null,
      "msg": "添加订单成功"
  }
  ```

  

## 删除订单

- URL：/delOrder

- method:post

- Request querystring

  ```
  userId:13
  orderItemId:9
  ```

- Response Body

  ```json
  {
      "flag": true,
      "data": null,
      "msg": "删除成功"
  }
  ```

## 更新订单(0:待支付;1:待商家发货;2:发货完成待签收3:签收完成;4:订单完成)

- URL：/updateOrder

- method:post

- Request querystring

  ```
  orderItemId:1
  status:1
  ```

- Response Body

  ```json
  {
      "flag": true,
      "data": null,
      "msg": "更新订单成功"
  }
  ```

  
