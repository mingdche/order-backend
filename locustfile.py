from locust import HttpUser, task, between

class OrderUser(HttpUser):
    wait_time = between(1, 3)

    @task
    def get_all_orders(self):
        self.client.get("/orders")

    @task
    def get_product(self):
        # 假设产品ID为1，您可以根据实际情况修改
        self.client.get("/orders/products/1")

    @task
    def read_s3_object(self):
        # 请根据实际情况修改region、bucket和object key
        self.client.get("/orders/s3/us-west-2/my-bucket/my-object.txt")

    def on_start(self):
        # 如果需要在测试开始时执行一些操作（如登录），可以在这里添加
        pass
