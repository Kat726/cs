package com.example.cucisepatutas.Model;

public class ModelAlamat {
    private String labelAlamat;
    private String SpesifikAlamatRumah1;

  public ModelAlamat() {

  }

    public ModelAlamat(String labelAlamat, String SpesifikAlamatRumah1) {
        this.labelAlamat = labelAlamat;
        this.SpesifikAlamatRumah1 = SpesifikAlamatRumah1;
    }

    public String getLabelAlamat() {
        return labelAlamat;
    }

    public void setLabelAlamat(String labelAlamat) {
        this.labelAlamat = labelAlamat;
    }

    public String getNoRumah() {
        return SpesifikAlamatRumah1;
    }

    public void setNo(String SpesifikAlamatRumah1) {
        this.SpesifikAlamatRumah1 = SpesifikAlamatRumah1;
    }

    public void setKey(String key) {
    }

    public String getKey() {
        return null;
    }
}
