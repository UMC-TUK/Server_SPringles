package com.umc.board.global.audit;

@SoftDelete
public interface Auditable {
    BaseTime getBaseTime();
    void setBaseTime(BaseTime baseTime);
}
