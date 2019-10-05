package com.github.bestheroz.sample.api.table.samplefilemst;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Arrays;

@SuppressWarnings("serial")
public class TestTableSampleFileMstVO implements Serializable {
    private Integer fileSeq;
    private String fileNm;
    private String fileNmExt;
    private String mimeTyp;
    private Byte[] fileData; // Arrays.copyOf(value, value.length)
    private String regMemberId;
    private DateTime regDt;
    private String updMemberId;
    private DateTime updDt;

    public Integer getFileSeq() {
        return this.fileSeq;
    }

    public void setFileSeq(final Integer fileSeq) {
        this.fileSeq = fileSeq;
    }

    public String getFileNm() {
        return this.fileNm;
    }

    public void setFileNm(final String fileNm) {
        this.fileNm = fileNm;
    }

    public String getFileNmExt() {
        return this.fileNmExt;
    }

    public void setFileNmExt(final String fileNmExt) {
        this.fileNmExt = fileNmExt;
    }

    public String getMimeTyp() {
        return this.mimeTyp;
    }

    public void setMimeTyp(final String mimeTyp) {
        this.mimeTyp = mimeTyp;
    }

    public Byte[] getFileData() {
        return Arrays.copyOf(this.fileData, this.fileData.length);
    }

    public void setFileData(final Byte[] fileData) {
        this.fileData = Arrays.copyOf(fileData, fileData.length);
    }

    public String getRegMemberId() {
        return this.regMemberId;
    }

    public void setRegMemberId(final String regMemberId) {
        this.regMemberId = regMemberId;
    }

    public DateTime getRegDt() {
        return this.regDt;
    }

    public void setRegDt(final DateTime regDt) {
        this.regDt = regDt;
    }

    public String getUpdMemberId() {
        return this.updMemberId;
    }

    public void setUpdMemberId(final String updMemberId) {
        this.updMemberId = updMemberId;
    }

    public DateTime getUpdDt() {
        return this.updDt;
    }

    public void setUpdDt(final DateTime updDt) {
        this.updDt = updDt;
    }

}