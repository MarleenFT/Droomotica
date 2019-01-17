package android.kaviles.bletutorial;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IntegerRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kelvin on 5/7/16.
 */
public class ListAdapter_BTLE_Devices extends ArrayAdapter<BTLE_Device> {

    Context mContext;
    int layoutResourceID;
    ArrayList<BTLE_Device> devices;

    public ListAdapter_BTLE_Devices(Context mContext, int resource, ArrayList<BTLE_Device> objects) {
        super(mContext, resource, objects);

        this.mContext = mContext;
        layoutResourceID = resource;
        devices = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutResourceID, parent, false);
        }

        BTLE_Device device = devices.get(position);
        String name = device.getName();
        String address = device.getAddress();
        int rssi = device.getRSSI();

        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
        if(name != null && name.length() > 0){
            tv_name.setText(device.getName());
        }
        else{
            tv_name.setText("No Name");
        }

        TextView tv_rssi = (TextView) convertView.findViewById(R.id.tv_rssi);
        tv_rssi.setText("RSSI " + Integer.toString(rssi));

        TextView tv_macaddr = (TextView) convertView.findViewById(R.id.tv_macaddr);
        if(address != null && address.length() > 0){
            tv_macaddr.setText(device.getAddress());
        }
        else {
            tv_macaddr.setText("No Address");
        }

        return convertView;
    }
}
