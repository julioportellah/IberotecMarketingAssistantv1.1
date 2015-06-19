package com.example.juliusdevelopment.iberotecmarketingassistantv11;

import android.app.Activity;
import android.app.ListFragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JuliusDevelopment on 13/06/2015.
 */
public class MyListFragment extends ListFragment implements OnItemClickListener {
    CustomAdapter adapter;
    //private List<Projects>projectItems;
    String[] menuTitles;
    TypedArray menuIcons;
    private List<RowItem> rowItems;


    //AQUI VAN LAS INTERFACES
    onItemSelectedListener mCallback;
    public interface onItemSelectedListener{
        public void onItemSelected(String message);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback=(onItemSelectedListener)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" must implement onItemSelectedListener");
        }
    }

    //AQUI ACABAN LAS INTERFACES
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment,null,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        menuTitles=getResources().getStringArray(R.array.picture_titles);
        menuIcons=getResources().obtainTypedArray(R.array.icons);
        rowItems=new ArrayList<RowItem>();
        for (int i=0;i<menuTitles.length;i++){
            RowItem items=new RowItem(menuTitles[i],menuIcons.getResourceId(i,-1));
            rowItems.add(items);
        }
        adapter=new CustomAdapter(getActivity(),rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(getActivity(),menuTitles[position],Toast.LENGTH_LONG).show();
        mCallback.onItemSelected(menuTitles[position]);
    }

    public void testingMessage(){
        Toast.makeText(getActivity(),"L'alizée",Toast.LENGTH_LONG).show();
    }

    //Seteando los adaptadores
    public void setVideoAdapter(){
        menuTitles=getResources().getStringArray(R.array.video_titles);
        menuIcons=getResources().obtainTypedArray(R.array.video_icons);
        rowItems=new ArrayList<RowItem>();
        for (int i=0;i<menuTitles.length;i++){
            RowItem items=new RowItem(menuTitles[i],menuIcons.getResourceId(i,-1));
            rowItems.add(items);
        }
        adapter=new CustomAdapter(getActivity(),rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    public void setVideoAdapter(boolean inverse){
        menuTitles=getResources().getStringArray(R.array.video_titles);
        menuIcons=getResources().obtainTypedArray(R.array.video_icons);
        rowItems=new ArrayList<RowItem>();
        for (int i=0;i<menuTitles.length;i++){
            RowItem items=new RowItem(menuTitles[i],menuIcons.getResourceId(i,-1));
            rowItems.add(items);
        }
        adapter=new CustomAdapter(getActivity(),rowItems,inverse);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    public void setPictureAdapter(){
        menuTitles=getResources().getStringArray(R.array.picture_titles);
        menuIcons=getResources().obtainTypedArray(R.array.icons);
        rowItems=new ArrayList<RowItem>();
        for (int i=0;i<menuTitles.length;i++){
            RowItem items=new RowItem(menuTitles[i],menuIcons.getResourceId(i,-1));
            rowItems.add(items);
        }
        adapter=new CustomAdapter(getActivity(),rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    public void setPictureAdapter(boolean inverse){
        menuTitles=getResources().getStringArray(R.array.picture_titles);
        menuIcons=getResources().obtainTypedArray(R.array.icons);
        rowItems=new ArrayList<RowItem>();
        for (int i=0;i<menuTitles.length;i++){
            RowItem items=new RowItem(menuTitles[i],menuIcons.getResourceId(i,-1));
            rowItems.add(items);
        }
        adapter=new CustomAdapter(getActivity(),rowItems,inverse);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


}
