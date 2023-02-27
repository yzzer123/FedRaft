# 读取Properties文件类
import logging

logging.basicConfig(format='%(asctime)s  %(name)s : %(levelname)s  %(message)s')


class Properties:
    logger: logging.Logger = None
    _conf: dict = None

    RAFT_SERVER_HOST = "manager.server.host"
    RAFT_SERVER_PORT = "manager.server.port"
    TRAINER_SERVER_PORT = "trainer.server.port.default"
    LOG_MODEL_CHUNK_SIZE = "log.model.chuck-size"
    TRAINER_SERVER_THREADS = "trainer.server.threads"
    TRAINER_CLIENT_THREADS = "trainer.client.threads"

    GRPC_CLIENT_OPTIONS = [('grpc.max_send_message_length', 512 * 1024 * 1024),
                           ('grpc.max_receive_message_length', 512 * 1024 * 1024)]

    LOGGING_LEVEL = logging.DEBUG

    @classmethod
    def init(cls):
        Properties.logger = logging.getLogger(str(Properties.__class__))
        # 如果配置文件还没加载，就从文件中读取配置
        Properties.logger.info("read config from conf.properties")
        try:
            with open("../conf/conf.properties", "r", encoding="utf-8") as conf_file:
                Properties._conf = {}
                for line in conf_file:
                    if line.find('=') > 0:
                        key_value = line.replace('\n', '').split('=')
                        Properties._conf[key_value[0]] = key_value[1]
        except Exception:
            Properties.logger("the config file doesn't exist")
            exit()

    @classmethod
    def getLogger(cls, name):
        # 如果配置文件还没加载，就从文件中读取配置
        logger = logging.getLogger(name)
        logger.setLevel(Properties.LOGGING_LEVEL)
        return logger

    @classmethod
    def get(cls, key: str) -> str:
        """
        获取项目全局配置, 名称不正确会返回None
        :param key: 配置名称
        :return: 配置值
        """

        if Properties._conf is None:
            Properties.init()

        return Properties._conf.get(key, None)

    @classmethod
    def getInt(cls, key: str) -> str:
        """
        获取项目全局配置, 名称不正确会返回None
        :param key: 配置名称
        :return: 配置值
        """
        value = Properties.get(key)
        if value is None:
            Properties.logger.warning(f"{key} config item doesn't exist")
            return 0

        return int(value)
