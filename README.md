# WsProxy

## 简介
WsProxy 是一个基于 Spring Boot 的 WebSocket 代理服务，它可以将 WebSocket 请求代理到指定的后端服务
- 支持 WebSocket 请求的代理
## 使用
### 1. 下载代码
```shell
git clone https://github.com/Kirito520Asuna/WsProxy.git
```
### 2. 新建配置文件 application-prod.yml
与.jar同一文件夹
```shell
server:
  port: 8080
  servlet:
    context-path: /ws-proxy
ws:
  url: ws://localhost:8081/ws #可忽略
  accessTokenName: access-token   
```
### 3. 运行
```shell
java -jar ws-proxy.jar
```
## 部署
### docker
```shell
docker pull ghcr.io/kirito520asuna/wsproxy:latest
docker run -d -p 8081:8081 ghcr.io/kirito520asuna/wsproxy:latest
```
## swagger 文档地址
```text
默认地址：http://localhost:8081/ws-proxy/doc.html
动态地址：http://127.0.0.1:${server.port:8080}${server.servlet.context-path:/}/doc.html
```

## Http请求示例
```http request
###
###没有配置token时，可忽略
POST http://localhost:8081/ws-proxy/message/send
Content-Type: application/json

{
  "url": "ws://127.0.0.1:8080/ws",
  "token": "token",
  "bodyJson": ""
}


###
POST http://localhost:8081/ws-proxy/message/api/send
Content-Type: application/json

{
  "url": "",
  "token": "",
  "bodyJson": ""
}

###
POST http://localhost:8081/ws-proxy/message/jwt/send
Content-Type: application/json

{
  "url": "",
  "token": "",
  "bodyJson": ""
}
```