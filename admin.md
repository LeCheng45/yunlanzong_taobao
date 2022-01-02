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
