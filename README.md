# 综合管理系统 
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)       [![star](https://gitee.com/ruyangit/tangdao/badge/star.svg?theme=gray)](https://gitee.com/ruyangit/tangdao/stargazers)

#### 项目介绍
开源，开源，开源。(github site: [https://tangdao.io](https://github.com/ruyangit/tangdao)) 

#### 技术选型
springboot，spring-security，spring-session，mybatis-plus，redis，fst，beetl...

#### 效果图示
<img src="doc/images/vb.png" width="50%" /><img src="doc/images/va.png" width="50%" />

#### 项目进度
<img src="doc/images/ta.png" width="50%" />

#### 安装教程
```
mvn clean install
```

### 运行开发环境
```
mvn springboot:run
```

### 打包压缩后的生产文件
```
mvn package -f pom.xml -Dmaven.test.skip=true
```

#### 使用说明

* 需要数据库MYSQL环境。
* 需要缓存REDIS服务。

#### 维护计划

* 本项目仅修复问题，不做新功能的开发。
* 重构项目拆分微服务。

#### 版权说明
本项目遵循 Apache License 2.0 协议。项目借鉴jeesite的设计思路，部分引用作者代码，仅用于学习和内部系统的使用。如有版权问题请联系我。如有需要请支持正版 <a href="https://gitee.com/thinkgem/jeesite4" target="_blank">jeesite</a>。

#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request
