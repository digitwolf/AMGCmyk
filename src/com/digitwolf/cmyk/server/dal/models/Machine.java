package com.digitwolf.cmyk.server.dal.models;


import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Руслан
 * Date: 10.06.13
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 */
@PersistenceCapable(detachable = "true")
public class Machine {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key id;

    @Persistent
    private String name;

    @Persistent
    private String type;

    @Persistent
    private String description;

    /**
     * *********************PAPER PROPERTIES*********************
     */

    /**
     * Minimal width of the paper, which can be inserted into the machine.
     */
    @Persistent
    private int paperWidthMin;

    /**
     * Minimal height of the paper, which can be inserted into the machine.
     */
    @Persistent
    private int paperLengthMin;


    /**
     * Maximum width of the paper, which can be inserted into the machine.
     */
    @Persistent
    private int paperWidthMax;

    /**
     * Maximum height of the paper, which can be inserted into the machine.
     */
    @Persistent
    private int paperLengthMax;
    
    @Persistent
    private int paperHeightMin;
    
    @Persistent
    private int paperHeightMax;

    @Persistent
    private int paperLoadSize;
    
    /**
     * Minimal density of the paper, which can be inserted into the machine.
     */
    @Persistent
    private int densityMin;

    /**
     * Maximum density of the paper, which can be inserted into the machine.
     */
    @Persistent
    private int densityMax;

    @Persistent
    private String productionRateName;

    @Persistent
    private int productionRate;

    /**
     *
     * *********************************SETUP*********************
     */
    @Persistent
    private boolean setupRequired;

    /**
     * Time for the machine setup
     */
    @Persistent
    private int setupTime;

    /**
     * Number of paper sheets wasted during the setup
     */
    @Persistent
    private int setupSheetWaste;

    @Persistent
    private int additionalCosts;

    /**
     * % of the waste rate for the tech. needs
     */
    @Persistent
    private int wasteRate;


    /**
     * Additional properties
     */
    @Persistent(mappedBy = "machine")
    private List<MachineProperty> extraProperties;

    /**
     * List of technological processes which can be comited by the machine.
     */
    @Persistent(mappedBy = "machine")
    private List<Techprocess> techprocesses;

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPaperWidthMin() {
        return paperWidthMin;
    }

    public void setPaperWidthMin(int paperWidthMin) {
        this.paperWidthMin = paperWidthMin;
    }

    public int getPaperLengthMin() {
        return paperLengthMin;
    }

    public void setPaperLengthMin(int paperLengthMin) {
        this.paperLengthMin = paperLengthMin;
    }

    public int getPaperWidthMax() {
        return paperWidthMax;
    }

    public void setPaperWidthMax(int paperWidthMax) {
        this.paperWidthMax = paperWidthMax;
    }

    public int getPaperLengthMax() {
        return paperLengthMax;
    }

    public void setPaperLengthMax(int paperLengthMax) {
        this.paperLengthMax = paperLengthMax;
    }

    public int getDensityMin() {
        return densityMin;
    }

    public void setDensityMin(int densityMin) {
        this.densityMin = densityMin;
    }

    public int getDensityMax() {
        return densityMax;
    }

    public void setDensityMax(int densityMax) {
        this.densityMax = densityMax;
    }

    public String getProductionRateName() {
        return productionRateName;
    }

    public void setProductionRateName(String productionRateName) {
        this.productionRateName = productionRateName;
    }

    public int getProductionRate() {
        return productionRate;
    }

    public void setProductionRate(int productionRate) {
        this.productionRate = productionRate;
    }

    public boolean issetupRequired() {
		return setupRequired;
	}

	public void setsetupRequired(boolean setupRequired) {
		this.setupRequired = setupRequired;
	}

	public int getSetupTime() {
        return setupTime;
    }

    public void setSetupTime(int setupTime) {
        this.setupTime = setupTime;
    }

    public int getSetupSheetWaste() {
        return setupSheetWaste;
    }

    public void setSetupSheetWaste(int setupSheetWaste) {
        this.setupSheetWaste = setupSheetWaste;
    }

    public int getAdditionalCosts() {
        return additionalCosts;
    }

    public void setAdditionalCosts(int additionalCosts) {
        this.additionalCosts = additionalCosts;
    }

    public int getWasteRate() {
        return wasteRate;
    }

    public void setWasteRate(int wasteRate) {
        this.wasteRate = wasteRate;
    }

    public List<MachineProperty> getExtraProperties() {
        return extraProperties;
    }

    public void setExtraProperties(List<MachineProperty> extraProperties) {
        this.extraProperties = extraProperties;
    }

    public Machine() {

    }

    public int getPaperHeightMin() {
        return paperHeightMin;
    }

    public void setPaperHeightMin(int paperHeightMin) {
        this.paperHeightMin = paperHeightMin;
    }

    public int getPaperHeightMax() {
        return paperHeightMax;
    }

    public void setPaperHeightMax(int paperHeightMax) {
        this.paperHeightMax = paperHeightMax;
    }

    public int getPaperLoadSize() {
        return paperLoadSize;
    }

    public void setPaperLoadSize(int paperLoadSize) {
        this.paperLoadSize = paperLoadSize;
    }

    public List<Techprocess> getTechprocesses() {
        return techprocesses;
    }

    public void setTechprocesses(List<Techprocess> techprocesses) {
        this.techprocesses = techprocesses;
    }
}
