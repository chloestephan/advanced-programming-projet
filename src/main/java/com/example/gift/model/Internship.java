package com.example.gift.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @NotBlank
    private String company;

    @NotBlank
    private String address;
    private Boolean specifications;
    private Boolean isVisitPlanned;
    private Boolean isVisitDone;
    private Boolean isVisitSheetCompleted;
    private Boolean isReportSubmitted;
    private Boolean isEvaluationSubmitted;
    private Boolean isSurveySubmitted;
    private Boolean isPresentationDone;

    @Min(value = 0)
    @Max(value = 20)
    private Float technicalGrade;

    @Min(value = 0)
    @Max(value = 20)
    private Float communicationGrade;
    @NotBlank
    private String supervisor;

    @NotNull
    @OneToOne
    private Intern intern;

    @NotNull
    @OneToOne
    private Tutor tutor;

    public Internship() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Boolean specifications) {
        this.specifications = specifications;
    }

    public Boolean getVisitPlanned() {
        return isVisitPlanned;
    }

    public void setVisitPlanned(Boolean visitPlanned) {
        isVisitPlanned = visitPlanned;
    }

    public Boolean getVisitDone() {
        return isVisitDone;
    }

    public void setVisitDone(Boolean visitDone) {
        isVisitDone = visitDone;
    }

    public Boolean getVisitSheetCompleted() {
        return isVisitSheetCompleted;
    }

    public void setVisitSheetCompleted(Boolean visitSheetCompleted) {
        isVisitSheetCompleted = visitSheetCompleted;
    }

    public Boolean getReportSubmitted() {
        return isReportSubmitted;
    }

    public void setReportSubmitted(Boolean reportSubmitted) {
        isReportSubmitted = reportSubmitted;
    }

    public Boolean getEvaluationSubmitted() {
        return isEvaluationSubmitted;
    }

    public void setEvaluationSubmitted(Boolean evaluationSubmitted) {
        isEvaluationSubmitted = evaluationSubmitted;
    }

    public Boolean getSurveySubmitted() {
        return isSurveySubmitted;
    }

    public void setSurveySubmitted(Boolean surveySubmitted) {
        isSurveySubmitted = surveySubmitted;
    }

    public Boolean getPresentationDone() {
        return isPresentationDone;
    }

    public void setPresentationDone(Boolean presentationDone) {
        isPresentationDone = presentationDone;
    }

    public Float getTechnicalGrade() {
        return technicalGrade;
    }

    public void setTechnicalGrade(Float technicalGrade) {
        this.technicalGrade = technicalGrade;
    }

    public Float getCommunicationGrade() {
        return communicationGrade;
    }

    public void setCommunicationGrade(Float communicationGrade) {
        this.communicationGrade = communicationGrade;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Intern getIntern() {
        return intern;
    }

    public void setIntern(Intern intern) {
        this.intern = intern;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
