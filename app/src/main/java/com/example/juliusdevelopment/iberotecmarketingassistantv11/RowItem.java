package com.example.juliusdevelopment.iberotecmarketingassistantv11;

/**
 * Created by JuliusDevelopment on 15/06/2015.
 */
public class RowItem {
    private String title;
    private int icon;

    public RowItem(String title, int icon){
        this.title=title;
        this.icon=icon;
    }

    public String getTitle(){
        return title;
    }

    public int getIcon() {
        return icon;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
