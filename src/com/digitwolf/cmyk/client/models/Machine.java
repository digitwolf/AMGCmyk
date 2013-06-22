package com.digitwolf.cmyk.client.models;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.jdo.annotations.Extension;
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
public class Machine implements IsSerializable {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;

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
    private int paperHeightMin;


    /**
     * Maximum width of the paper, which can be inserted into the machine.
     */
    @Persistent
    private int paperWidthMax;

    /**
     * Maximum height of the paper, which can be inserted into the machine.
     */
    @Persistent
    private int paperHeightMax;
    
    @Persistent
    private int paperThickMin;
    
    @Persistent
    private int paperThickMax;

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
    private boolean sutupRequired;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public float getPaperWidthMin() {
        return paperWidthMin;
    }

    public void setPaperWidthMin(int paperWidthMin) {
        this.paperWidthMin = paperWidthMin;
    }

    public float getPaperHeightMin() {
        return paperHeightMin;
    }

    public void setPaperHeightMin(int paperHeightMin) {
        this.paperHeightMin = paperHeightMin;
    }

    public float getPaperWidthMax() {
        return paperWidthMax;
    }

    public void setPaperWidthMax(int paperWidthMax) {
        this.paperWidthMax = paperWidthMax;
    }

    public float getPaperHeightMax() {
        return paperHeightMax;
    }

    public void setPaperHeightMax(int paperHeightMax) {
        this.paperHeightMax = paperHeightMax;
    }

    public float getDensityMin() {
        return densityMin;
    }

    public void setDensityMin(int densityMin) {
        this.densityMin = densityMin;
    }

    public float getDensityMax() {
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

    public boolean isSutupRequired() {
		return sutupRequired;
	}

	public void setSutupRequired(boolean sutupRequired) {
		this.sutupRequired = sutupRequired;
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

    public float getAdditionalCosts() {
        return additionalCosts;
    }

    public void setAdditionalCosts(int additionalCosts) {
        this.additionalCosts = additionalCosts;
    }

    public float getWasteRate() {
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
}
