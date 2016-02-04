package com.example.jamel.todolist;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView listItems;
    private ArrayList<String> items;
    private ArrayAdapter itemsAdapter;
    private CheckBox checkbox;
    MyCustomAdapter dataAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        displayListView();

    }

    private void displayListView() {

        ArrayList<ToDoItem> ToDoList = new ArrayList<ToDoItem>();
       ToDoItem item = new ToDoItem("Steam Tunneling","Go steam tunneling and see the murals",false);
        ToDoList.add(item);
       item = new ToDoItem("Dining Hall Dash","Eat at all the UVA dining halls in one day",false);
        ToDoList.add(item);
       item = new ToDoItem("Observatory Night Show","Go to the observatory hill at night and stargaze",false);
        ToDoList.add(item);
       item = new ToDoItem("Humpback Rock","Hike Humpback Rock and watch the sunrise",false);
        ToDoList.add(item);
       item = new ToDoItem("Steam Tunneling","Go steam tunneling and see the murals",false);
        ToDoList.add(item);

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.to_do_info, ToDoList);
        ListView listView = (ListView) findViewById(R.id.listItems);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                ToDoItem item = (ToDoItem) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Clicked on Row: " + item.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private class MyCustomAdapter extends ArrayAdapter<ToDoItem> {

        private ArrayList<ToDoItem> toDoList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<ToDoItem> toDoItems) {
            super(context, textViewResourceId, toDoItems);
            this.toDoList = new ArrayList<ToDoItem>();
            this.toDoList.addAll(toDoItems);
        }

        private class ViewHolder {
            TextView name;
            CheckBox description;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.to_do_info, null);

                holder = new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.code);
                holder.description = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        /**
                        CheckBox cb = (CheckBox) v ;
                        ToDoItem item = (ToDoItem) cb.getTag();
                        Toast.makeText(getApplicationContext(),
                                "Clicked on Checkbox: " + cb.getText() +
                                        " is " + cb.isChecked(),
                                Toast.LENGTH_LONG).show();
                        item.setSelected(cb.isChecked());
                         **/
                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            ToDoItem newItem = toDoList.get(position);
            holder.name.setText(" (" + newItem.getDescription()  + ")");
            holder.name.setText(newItem.getName());
            //holder.name.setChecked(newItem.isSelected());
            holder.name.setTag(newItem);

            return convertView;

        }

    }

    private static class itemHolder {
        private TextView toDoListItem;
        private CheckBox checkBox;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

}