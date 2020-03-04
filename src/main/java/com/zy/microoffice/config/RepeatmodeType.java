package com.zy.microoffice.config;

/**
 * 重复模型类型  0-不重复 1-每天重复 2-每周重复 3-每月重复 4-每年重复 5-每个工作日重复
 */
public enum RepeatmodeType {
    NotRepeat(0),DayRepeat(1),WeekRepeat(2),MonthRepeat(3),YearRepeat(4),WorkDayRepeat(5);

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    RepeatmodeType(int index) {
        this.index = index;
    }
}
