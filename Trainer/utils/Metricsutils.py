from time import time
from utils.Configuration import Properties

logger = Properties.getLogger(__name__)


class TimeMetric:
    """时间计数类 用于计算性能耗时
    在创建对象时，会将当前时间标记为开始时间
    """

    def __init__(self) -> None:
        self.time_sub = time()

    def mark(self) -> int:
        """计算距离上一个mark过去了多久，并将重新mark当前时间

        Returns:
            int: 耗时
        """
        now = time()
        time_interval = now - self.time_sub
        self.time_sub = now
        return int(time_interval * 1000)
