package com.revature.assignforce.beans;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "SETTINGS")
public class Setting {

    @Id
    @Column(name = "SETTINGID")
    @SequenceGenerator(name="SETTING_ID_GEN", sequenceName="SETTING_ID", initialValue = 1, allocationSize=1)
    @GeneratedValue(generator="SETTING_ID_GEN", strategy=GenerationType.SEQUENCE)
    private int settingId;
    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name="USERID")
    private User user;
    @Column(name = "TRAINERS_PER_PAGE")
    private int timelineTrainersPerPage;
    @Column(name = "OUTGOING_GRADS")
    private int outgoingGrads;
    @Column(name = "INCOMING_CANDIDATES")
    private int incomingCandidates;
    @Column(name = "MIN_BATCH")
    private int minBatch;
    @Column(name = "MAX_BATCH")
    private int maxBatch;
    @Column(name = "DEFAULT_BATCH_LENGTH")
    private int defaultBatchLength;
    @Column(name = "MIN_DAYS_BETWEEN_BATCHES")
    private int minDaysBetweenBatches;
    @Column(name = "DEFAULT_BATCH_NAME_PATTERN")
    private String defaultBatchNamePattern;

    public Setting() {
    }

    public Setting(User user, int timelineTrainersPerPage, int outgoingGrads, int incomingCandidates, int minBatch,
                   int maxBatch, int defaultBatchLength, int minDaysBetweenBatches, String defaultBatchNamePattern) {
        this.user = user;
        this.timelineTrainersPerPage = timelineTrainersPerPage;
        this.outgoingGrads = outgoingGrads;
        this.incomingCandidates = incomingCandidates;
        this.minBatch = minBatch;
        this.maxBatch = maxBatch;
        this.defaultBatchLength = defaultBatchLength;
        this.minDaysBetweenBatches = minDaysBetweenBatches;
        this.defaultBatchNamePattern = defaultBatchNamePattern;
    }

    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTimelineTrainersPerPage() {
        return timelineTrainersPerPage;
    }

    public void setTimelineTrainersPerPage(int timelineTrainersPerPage) {
        this.timelineTrainersPerPage = timelineTrainersPerPage;
    }

    public int getOutgoingGrads() {
        return outgoingGrads;
    }

    public void setOutgoingGrads(int outgoingGrads) {
        this.outgoingGrads = outgoingGrads;
    }

    public int getIncomingCandidates() {
        return incomingCandidates;
    }

    public void setIncomingCandidates(int incomingCandidates) {
        this.incomingCandidates = incomingCandidates;
    }

    public int getMinBatch() {
        return minBatch;
    }

    public void setMinBatch(int minBatch) {
        this.minBatch = minBatch;
    }

    public int getMaxBatch() {
        return maxBatch;
    }

    public void setMaxBatch(int maxBatch) {
        this.maxBatch = maxBatch;
    }

    public int getDefaultBatchLength() {
        return defaultBatchLength;
    }

    public void setDefaultBatchLength(int defaultBatchLength) {
        this.defaultBatchLength = defaultBatchLength;
    }

    public int getMinDaysBetweenBatches() {
        return minDaysBetweenBatches;
    }

    public void setMinDaysBetweenBatches(int minDaysBetweenBatches) {
        this.minDaysBetweenBatches = minDaysBetweenBatches;
    }

    public String getDefaultBatchNamePattern() {
        return defaultBatchNamePattern;
    }

    public void setDefaultBatchNamePattern(String defaultBatchNamePattern) {
        this.defaultBatchNamePattern = defaultBatchNamePattern;
    }
}
