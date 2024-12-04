# 使用一个基础的Java镜像作为基础镜像
# 这是 Amazon 提供的 OpenJDK 发行版镜像,例如 amazoncorretto:11、amazoncorretto:17等。
# 它们经过了 Amazon 的优化和加固,在性能和安全性方面有一定增强。适合在 AWS 环境中使用。

FROM public.ecr.aws/amazoncorretto/amazoncorretto:17
# 设置工作目录
WORKDIR /app
# 将本地的Spring Boot JAR文件复制到容器中
COPY target/order-backend-0.0.1-SNAPSHOT.jar app.jar
# 暴露应用运行的端口（根据你的应用需要）
EXPOSE 8080

# 定义启动命令, 建议在生产环境中使用ENTRYPOINT，保证启动命令不被覆盖
ENTRYPOINT [ "java", "-jar", "app.jar"]


#finch tag \
#order-backend:latest \
#$AWS_ACCOUNT_ID.dkr.ecr.$AWS_REGION.amazonaws.com/order/order-backend:latest

