package org.bupt.fedraft.job.jobmanager;

import org.bupt.fedraft.state.JobManager;
import org.bupt.fedraft.state.ManagerState;

/**
 * @author yzzer
 */
public class Candidate extends BaseJob {
    public Candidate(JobManager manager, ManagerState managerState) {
        super(manager, managerState);
    }

    @Override
    public void setupTimer() {

    }

    @Override
    public void closeTimer() {

    }
}
