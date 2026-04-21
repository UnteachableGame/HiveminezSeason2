package me.unteachable.hiveminezSeason2.utils.npc;

public class SkinData {

    private String texture;
    private String signature;
    private boolean ownSkin = false;

    public SkinData(String texture, String signature) {
        this.texture = texture;
        this.signature = signature;
    }

    public SkinData(boolean ownSkin) {
        this.ownSkin = ownSkin;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public boolean isOwnSkin() {
        return ownSkin;
    }

}
