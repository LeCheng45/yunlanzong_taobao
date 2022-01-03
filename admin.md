# 管理员API

---

## 管理员登录

- URL：/admin/login
- method:post
- Request querystring

```json
loginName:admin
password:123456
```

* Response Body

```json
#登陆成功
{
    "flag": true,
    "data": null,
    "msg": "登录成功"
}

#登陆失败
{
    "flag": false,
    "data": null,
    "msg": "账号或密码错误"
}
```



## 管理员个人信息

- URL：/admin/info
- method:get
- Request querystring

```json
adminId:1
```

* Response Body

```json
{
    "flag": true,
    "data": {
        "adminId": 1,
        "adminName": "admin",
        "adminPassword": "e10adc3949ba59abbe56e057f20f883e",
        "nickName": "十三",
        "locked": 0
    },
    "msg": "查询管理员信息成功"
}
```



## 所有用户信息

- URL：/admin/usersInfo
- method:get
- Request querystring

```json
无
```

* Response Body

```json
{
    "flag": true,
    "data": [
        {
            "userId": 1,
            "nickName": "十三",
            "loginName": "13700002703",
            "passwordMd5": "e10adc3949ba59abbe56e057f20f883e",
            "introduceSign": "我不怕千万人阻挡，只怕自己投降",
            "isDeleted": 0,
            "lockedFlag": 0,
            "createTime": "2020-05-22T08:44:57"
        },
        {
            "userId": 6,
            "nickName": "陈尼克",
            "loginName": "13711113333",
            "passwordMd5": "e10adc3949ba59abbe56e057f20f883e",
            "introduceSign": "测试用户陈尼克",
            "isDeleted": 0,
            "lockedFlag": 0,
            "createTime": "2020-05-22T08:44:57"
        },
        {
            "userId": 13,
            "nickName": "测试用例",
            "loginName": "13307911234",
            "passwordMd5": "e10adc3949ba59abbe56e057f20f883e",
            "introduceSign": "测试",
            "isDeleted": 0,
            "lockedFlag": 0,
            "createTime": "2021-12-30T15:52:57"
        },
        {
            "userId": 14,
            "nickName": "测试用例2",
            "loginName": "13412341234",
            "passwordMd5": "e10adc3949ba59abbe56e057f20f883e",
            "introduceSign": "测试2",
            "isDeleted": 0,
            "lockedFlag": 0,
            "createTime": "2021-12-30T15:53:30"
        },
        {
            "userId": 15,
            "nickName": "测试用例3",
            "loginName": "12341234121",
            "passwordMd5": "e10adc3949ba59abbe56e057f20f883e",
            "introduceSign": "测试3",
            "isDeleted": 0,
            "lockedFlag": 0,
            "createTime": "2021-12-30T15:54:02"
        }
    ],
    "msg": "获取用户信息成功"
}
```



## 修改用户信息

- URL：/admin/usersInfo/update
- method:post
- Request querystring

```json
#post的内容
{
    "userId": 15,
    "nickName": "测试",
    "loginName": "12341234123",
    "passwordMd5": "e10adc3949ba59abbe56e057f20f883e",
    "introduceSign": "ceshi",
    "isDeleted": 0,
    "lockedFlag": 0
}
```

配置文件加这个*后端的配置文件*

```yaml
  jackson:
    property-naming-strategy: LOWER_CAMEL_CASE
```

* Response body

```json
#结果
{
    "flag": true,
    "data": null,
    "msg": "修改用户信息成功"
}
#用户不存在时
{
    "flag": false,
    "data": null,
    "msg": "用户不存在"
}
```



## 删除用户信息

- URL：/admin/usersInfo/delete
- method:post
- Request querystring

```json
userId:15
```

* Response body

```json
{
    "flag": true,
    "data": null,
    "msg": "删除用户成功"
}
#用户不存在时
{
    "flag": false,
    "data": null,
    "msg": "用户不存在"
}
```



## 插入用户信息

- URL：/admin/usersInfo/insert
- method:post
- Request querystring

```json
#post
{
    "userId": 16,
    "nickName": "测试666",
    "loginName": "12341234123",
    "passwordMd5": "e10adc3949ba59abbe56e057f20f883e",
    "introduceSign": "ceshi",
    "isDeleted": 0,
    "lockedFlag": 0
}
```

* Response body

```json
{
    "flag": true,
    "data": null,
    "msg": "添加用户信息成功"
}

{
    "flag": false,
    "data": null,
    "msg": "用户已存在"
}
```

###### 所有商店信息

* URL：/admin/storesInfo

* method: get

* Request querystring

```json
无
```

* Response body

```json
{
    "flag": true,
    "data": [
        {
            "storeId": 2,
            "storeName": "地摊",
            "userId": 6,
            "introduceSign": "走过路过不要错过",
            "isDeleted": 0,
            "lockedFlag": 0,
            "createTime": "2021-12-29T17:20:39"
        },
        {
            "storeId": 3,
            "storeName": "哈哈哈",
            "userId": 6,
            "introduceSign": "哈哈哈哈哈",
            "isDeleted": 0,
            "lockedFlag": 0,
            "createTime": "2021-12-29T17:20:39"
        },
        {
            "storeId": 4,
            "storeName": "尼美舒利",
            "userId": 1,
            "introduceSign": "测试",
            "isDeleted": 0,
            "lockedFlag": 0,
            "createTime": "2021-12-30T15:54:51"
        },
        {
            "storeId": 13,
            "storeName": "万药阁",
            "userId": 13,
            "introduceSign": "买不了吃亏买不了上当",
            "isDeleted": 0,
            "lockedFlag": 0,
            "createTime": "2021-12-29T17:20:39"
        }
    ],
    "msg": "获取商店信息成功"
}
```



###### 修改店铺信息

* URL：/admin/storesInfo/update

* method: post

* Request querystring

```json
{
    "storeId": 13,
    "storeName": "万药阁",
    "userId": 13,
    "introduceSign": "买不了吃亏买不了上当233",
    "isDeleted": 0,
    "lockedFlag": 0
}
```

* Response body

```json
{
    "flag": true,
    "data": null,
    "msg": "修改店铺信息成功"
}
```



###### 删除店铺

* URL：/admin/storesInfo/delete

* method: post

* Request querystring

```json
storeId:15
```

* Response body

```json
{
    "flag": true,
    "data": null,
    "msg": "删除店铺成功"
}
```



###### 添加店铺

* URL：/admin/storesInfo/insert

* method: post

* Request querystring

```json
{
    "storeId": 16,
    "storeName": "测试233",
    "userId": 2,
    "introduceSign": "2333",
    "isDeleted": 0,
    "lockedFlag": 0
}
```

* Response body

```json
{
    "flag": true,
    "data": null,
    "msg": "添加店铺信息成功"
}
```



###### 所有商品信息

* URL：/admin/storesInfo/goods

* method: post

* Request querystring

```json
storeId:13
```

* Response body

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
            "goodsId": 4,
            "goodsName": "筑基丹",
            "goodsIntro": "提升肉体强度，为突破筑基提供能量",
            "goodsCategoryId": 15,
            "goodsCoverImg": "/admin/dist/img/no-img.png",
            "goodsDetailContent": "神奇的丹药",
            "originalPrice": 111,
            "sellingPrice": 111,
            "stockNum": 123,
            "storeName": "万药阁"
        },
        {
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
        {
            "goodsId": 6,
            "goodsName": "还元丹",
            "goodsIntro": "一种治疗内伤的丹药",
            "goodsCategoryId": 15,
            "goodsCoverImg": "/admin/dist/img/no-img.png",
            "goodsDetailContent": "好神奇的丹药",
            "originalPrice": 1,
            "sellingPrice": 1,
            "stockNum": 10,
            "storeName": "万药阁"
        },
        {
            "goodsId": 7,
            "goodsName": "反命丹",
            "goodsIntro": "吃了会反命",
            "goodsCategoryId": 15,
            "goodsCoverImg": "/admin/dist/img/no-img.png",
            "goodsDetailContent": "真的好神奇的丹药",
            "originalPrice": 1,
            "sellingPrice": 1,
            "stockNum": 10,
            "storeName": "万药阁"
        },
        {
            "goodsId": 8,
            "goodsName": "合欢散",
            "goodsIntro": "嗯~你懂的",
            "goodsCategoryId": 15,
            "goodsCoverImg": "/admin/dist/img/no-img.png",
            "goodsDetailContent": "神奇啊，这丹药",
            "originalPrice": 1,
            "sellingPrice": 1,
            "stockNum": 10,
            "storeName": "万药阁"
        },
        {
            "goodsId": 9,
            "goodsName": "培元丹",
            "goodsIntro": "吃了会培元",
            "goodsCategoryId": 15,
            "goodsCoverImg": "/admin/dist/img/no-img.png",
            "goodsDetailContent": "买到就是赚到",
            "originalPrice": 1,
            "sellingPrice": 1,
            "stockNum": 10,
            "storeName": "万药阁"
        },
        {
            "goodsId": 10,
            "goodsName": "归元丹",
            "goodsIntro": "吃了会归元",
            "goodsCategoryId": 15,
            "goodsCoverImg": "/admin/dist/img/no-img.png",
            "goodsDetailContent": "神奇的丹药，嗯",
            "originalPrice": 1,
            "sellingPrice": 1,
            "stockNum": 10,
            "storeName": "万药阁"
        },
        {
            "goodsId": 11,
            "goodsName": "腾龙丹",
            "goodsIntro": "吃了变龙",
            "goodsCategoryId": 15,
            "goodsCoverImg": "/admin/dist/img/no-img.png",
            "goodsDetailContent": "神奇的不能在神奇的丹药，懂的都懂，不懂的我也不多解释，库存就这么多，要买就买不买就求求你快买吧，这么好的丹药啊~~~",
            "originalPrice": 1,
            "sellingPrice": 1,
            "stockNum": 10,
            "storeName": "万药阁"
        },
        {
            "goodsId": 12,
            "goodsName": "忘忧丹",
            "goodsIntro": "吃了忘忧",
            "goodsCategoryId": 15,
            "goodsCoverImg": "/admin/dist/img/no-img.png",
            "goodsDetailContent": "神奇啊",
            "originalPrice": 1,
            "sellingPrice": 1,
            "stockNum": 10,
            "storeName": "万药阁"
        },
        {
            "goodsId": 13,
            "goodsName": "灵兽丹",
            "goodsIntro": "给灵兽吃的，人也可以吃",
            "goodsCategoryId": 15,
            "goodsCoverImg": "/admin/dist/img/no-img.png",
            "goodsDetailContent": "好神奇啊",
            "originalPrice": 1,
            "sellingPrice": 1,
            "stockNum": 10,
            "storeName": "万药阁"
        },
        {
            "goodsId": 14,
            "goodsName": "混元丹",
            "goodsIntro": "吃了会混元",
            "goodsCategoryId": 15,
            "goodsCoverImg": "/admin/dist/img/no-img.png",
            "goodsDetailContent": "太神奇了",
            "originalPrice": 1,
            "sellingPrice": 1,
            "stockNum": 10,
            "storeName": "万药阁"
        },
        {
            "goodsId": 15,
            "goodsName": "戒灵尺",
            "goodsIntro": "强大的武器",
            "goodsCategoryId": 19,
            "goodsCoverImg": "/admin/dist/img/no-img.png",
            "goodsDetailContent": "武器，很强的",
            "originalPrice": 123456,
            "sellingPrice": 999,
            "stockNum": 10,
            "storeName": "万药阁"
        },
        {
            "goodsId": 16,
            "goodsName": "狲钨箜",
            "goodsIntro": "曦囿骥里的宠物",
            "goodsCategoryId": 20,
            "goodsCoverImg": "/admin/dist/img/no-img.png",
            "goodsDetailContent": "强大的灵宠",
            "originalPrice": 987654,
            "sellingPrice": 999,
            "stockNum": 10,
            "storeName": "万药阁"
        },
        {
            "goodsId": 17,
            "goodsName": "青莲地心火",
            "goodsIntro": "生长于海底火山口的莲花炼化出来的火焰，万物可燃",
            "goodsCategoryId": 18,
            "goodsCoverImg": "/admin/dist/img/no-img.png",
            "goodsDetailContent": "异火",
            "originalPrice": 1000,
            "sellingPrice": 10,
            "stockNum": 0,
            "storeName": "万药阁"
        }
    ],
    "msg": "获取商品信息成功"
}
```



###### 所有订单信息

* URL: /admin/ordersInfo

* method: get

* Request querystring

```json
无
```

* Response body

```json
{
    "flag": true,
    "data": [
        {
            "orderItemId": 1,
            "goodsId": 1,
            "goodsName": "大还丹",
            "categoryId": null,
            "goodsCoverImg": "",
            "sellingPrice": 999,
            "goodsCount": 10,
            "createTime": "2021-12-29T17:22:37",
            "orderStatus": 0
        },
        {
            "orderItemId": 2,
            "goodsId": 2,
            "goodsName": "天鼎",
            "categoryId": null,
            "goodsCoverImg": "",
            "sellingPrice": 1000,
            "goodsCount": 1,
            "createTime": "2021-12-29T17:22:37",
            "orderStatus": 0
        },
        {
            "orderItemId": 3,
            "goodsId": 3,
            "goodsName": "焚决",
            "categoryId": null,
            "goodsCoverImg": "",
            "sellingPrice": 1000000000,
            "goodsCount": 1,
            "createTime": "2021-12-29T17:22:37",
            "orderStatus": 0
        },
        {
            "orderItemId": 4,
            "goodsId": 6,
            "goodsName": "还元丹",
            "categoryId": null,
            "goodsCoverImg": "",
            "sellingPrice": 1000,
            "goodsCount": 1,
            "createTime": "2021-12-30T16:28:36",
            "orderStatus": 0
        },
        {
            "orderItemId": 5,
            "goodsId": 7,
            "goodsName": "反命丹",
            "categoryId": null,
            "goodsCoverImg": "",
            "sellingPrice": 1000,
            "goodsCount": 1,
            "createTime": "2021-12-30T16:28:36",
            "orderStatus": 0
        },
        {
            "orderItemId": 6,
            "goodsId": 8,
            "goodsName": "合欢散",
            "categoryId": null,
            "goodsCoverImg": "",
            "sellingPrice": 1000,
            "goodsCount": 1,
            "createTime": "2021-12-30T16:28:36",
            "orderStatus": 0
        },
        {
            "orderItemId": 7,
            "goodsId": 9,
            "goodsName": "培元丹",
            "categoryId": null,
            "goodsCoverImg": "",
            "sellingPrice": 1000,
            "goodsCount": 1,
            "createTime": "2021-12-30T16:28:36",
            "orderStatus": 0
        },
        {
            "orderItemId": 8,
            "goodsId": 9,
            "goodsName": "培元丹",
            "categoryId": null,
            "goodsCoverImg": "/admin/dist/img/no-img.png",
            "sellingPrice": 1,
            "goodsCount": 1,
            "createTime": "2021-12-31T10:49:45",
            "orderStatus": 0
        }
    ],
    "msg": "获取订单信息成功"
}
```



###### 修改订单信息

* URL: /admin/ordersInfo/update

* method: post

* Request querystring

```json
{
    "orderItemId": 9,
    "goodsId": 9,
    "goodsName": "培元丹2333",
    "categoryId": null,
    "goodsCoverImg": "",
    "sellingPrice": 1000,
    "goodsCount": 99,
    "createTime": "2021-12-30T16:28:36",
    "orderStatus": 0
}
```

* Response body

```json
{
    "flag": true,
    "data": null,
    "msg": "修改订单信息成功"
}
```



###### 删除订单信息

* URL: /admin/ordersInfo/delete

* method: post
* Request querystring

```json
orderItemId:9
```

* Response body

```json
{
    "flag": true,
    "data": null,
    "msg": "删除订单成功"
}
```



# 添加订单信息

* URL: /admin/ordersInfo/insert

* method: post

* Request querystring

```json
{
    "orderItemId": 9,
    "goodsId": 9,
    "goodsName": "培元丹",
    "categoryId": null,
    "goodsCoverImg": "",
    "sellingPrice": 1000,
    "goodsCount": 99,
    "createTime": "2021-12-30T16:28:36",
    "orderStatus": 0
}
```

* Response body

```json
{
    "flag": true,
    "data": null,
    "msg": "添加订单信息成功"
}
```

# 修改商品

* URL: /admin/storesInfo/goods/update

* method: post

* Request querystring

```json
goodsId:21
goodsName:高级版葵花宝典
goodsIntro:不是什么人都能学的哦
goodsDetailContent:不是什么人都能学的哦
sellingPrice:1999

```

* Response body

```json
{
    "flag": true,
    "data": null,
    "msg": "修改商品信息成功"
}
```

# 删除商品

* URL: /admin/storesInfo/goods/delete

* method: post

* Request querystring

```json
goodsId:21
```

* Response body

```json
{
    "flag": true,
    "data": null,
    "msg": "删除商品成功"
}
```

# 
