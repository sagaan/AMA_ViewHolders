package com.ama.viewholders;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] listitas = {"Carne Asada", "Pastor", "Pollo", "Lengua", "Tripa", "Suadero"};
        int[] img = {R.drawable.asada, R.drawable.pastor, R.drawable.pollo, R.drawable.lengua, R.drawable.tripa, R.drawable.suadero};
        ListView lista = new ListView(this);

        final Tacos[] listTacos = {
                new Tacos(listitas[0], img[0]),
                new Tacos(listitas[1], img[1]),
                new Tacos(listitas[2], img[2]),
                new Tacos(listitas[3], img[3]),
                new Tacos(listitas[4], img[4]),
                new Tacos(listitas[5], img[5])
        };
        setContentView(lista);

        //ArrayAdapter<Tacos> adaptador = new ArrayAdapter<Tacos>(this, R.layout.renglon, R.id.txtRenglon, listTacos);

        ArrayAdapter<Tacos> tacosAdapter = new ArrayAdapter<Tacos>(this, 0, listTacos){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                ViewHolder viewHolder = new ViewHolder();
                Tacos taco = listTacos[position];

                if(convertView == null){
                    convertView = getLayoutInflater().inflate(R.layout.renglon, null, false);
                }

                viewHolder.setTxtNombre((TextView) convertView.findViewById(R.id.txtRenglon));
                viewHolder.setImgTaco((ImageView) convertView.findViewById(R.id.imgTaco));

                convertView.setTag(viewHolder);

                TextView txtNombre = ((ViewHolder)convertView.getTag()).getTxtNombre();
                ImageView imgTaco = ((ViewHolder)convertView.getTag()).getImgTaco();

                txtNombre.setText(taco.getNombre());
                imgTaco.setImageResource(taco.getImagen());

                return convertView;
            }
        };

        lista.setAdapter(tacosAdapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Random generator = new Random();

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(parent,("$"+generator.nextInt(200)),Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
