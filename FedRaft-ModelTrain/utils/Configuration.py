# 读取Properties文件类
class Properties:
    _conf: dict = None

    RAFT_SERVER_HOST = "raft.server.host"
    RAFT_SERVER_PORT = "raft.server.port"
    TRAINER_SERVER_PORT = "trainer.server.port"
    LOG_MODEL_CHUNKSIZE = "log.model.chucksize"

    @classmethod
    def get(cls, key: str):
        """
        获取项目全局配置, 名称不正确会返回None
        :param key: 配置名称
        :return: 配置值
        """

        if Properties._conf is None:
            # 如果配置文件还没加载，就从文件中读取配置
            with open("../conf.properties", "r", encoding="utf-8") as conf_file:
                Properties._conf = {}
                for line in conf_file:
                    if line.find('=') > 0:
                        key_value = line.replace('\n', '').split('=')
                        Properties._conf[key_value[0]] = key_value[1]

        return Properties._conf.get(key, None)
