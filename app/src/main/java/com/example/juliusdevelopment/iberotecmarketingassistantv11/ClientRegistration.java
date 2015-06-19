package com.example.juliusdevelopment.iberotecmarketingassistantv11;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by JuliusDevelopment on 15/05/2015.
 */
public class ClientRegistration extends Activity{
    Button buttonSaveData;
    //Campos OPCIONALES
    EditText institucionProcedencia,distritoProcedencia,tipoEvento;
    EditText edad,fechaNacimiento;
    RadioButton isMale,isFemale;
    EditText domicilio,provincia,departamento;
    CheckBox medioEmail,medioWeb,medioReferencia,medioPapel,medioRadio,medioTV,medioFeria;
    EditText medioOtros;

    //Parte Superior
    //Campos Obligatorios
    private TextView lblFecha;
    //Parte de los nombres
    EditText apellidoPaterno,apellidoMaterno,nombresCompletos;
    //Parte de lalos datos personales
    EditText numeroDNI;
    //Parte de domicilio
    EditText distrito;
    //Parte de telefono,cel y correo
    EditText telefonoCasa, telefonoCelular, correoElectronico;
    //Parte de intereses
    EditText interesCursoTexto;

    CheckBox interesTelematica,interesTelecomunicaciones,interesCurso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_formulary);


        lblFecha = (TextView) findViewById(R.id.lblDate);
        lblFecha.setText(getLocalTime());
        buttonSaveData = (Button) findViewById(R.id.guardar_datos);
        //buttonSaveData.setOnClickListener(saveHandler);

        //DECLARANDO CAMPOS OPCIONALES
        //Componentes de la ficha de datos
        institucionProcedencia=(EditText)findViewById(R.id.institucion_procedencia);
        distritoProcedencia=(EditText)findViewById(R.id.distrito_procedencia);
        tipoEvento=(EditText)findViewById(R.id.tipo_de_evento);
        //Componentes de la ficha de datos personales
        edad=(EditText)findViewById(R.id.edad);
        fechaNacimiento=(EditText)findViewById(R.id.fecha_nacimiento);
        isMale=(RadioButton)findViewById(R.id.is_male);
        isFemale=(RadioButton)findViewById(R.id.is_female);
        //Componentes de direccion
        domicilio=(EditText)findViewById(R.id.domicilio);
        provincia=(EditText)findViewById(R.id.provincia);
        departamento=(EditText)findViewById(R.id.departamento);
        //Componentes de enterado
        medioEmail=(CheckBox)findViewById(R.id.medio_e_mail);
        medioWeb=(CheckBox)findViewById(R.id.medio_web);
        medioReferencia=(CheckBox)findViewById(R.id.medio_referencia);
        medioPapel=(CheckBox)findViewById(R.id.medio_papel);
        medioTV=(CheckBox)findViewById(R.id.medio_tv);
        medioFeria=(CheckBox)findViewById(R.id.medio_feria);
        medioRadio=(CheckBox)findViewById(R.id.medio_radio);
        medioOtros=(EditText)findViewById(R.id.medio_otros);

        //DECLARANDO CAMPOS OBLIGATORIOS
        //Declarando nombres
        apellidoPaterno=(EditText)findViewById(R.id.apellido_paterno);
        apellidoMaterno=(EditText)findViewById(R.id.apellido_materno);
        nombresCompletos=(EditText)findViewById(R.id.nombres_completos);
        //Declarando datosPersonales
        numeroDNI=(EditText)findViewById(R.id.dni);
        //Declarando Distrito
        distrito=(EditText)findViewById(R.id.distrito);
        //Declarando Datos
        telefonoCasa=(EditText)findViewById(R.id.telefono_casa);
        telefonoCelular=(EditText)findViewById(R.id.celular);
        correoElectronico=(EditText)findViewById(R.id.correo_electronico);
        //Declarando Intereses
        interesCursoTexto=(EditText)findViewById(R.id.tipo_de_curso);
        interesTelecomunicaciones=(CheckBox)findViewById(R.id.interes_telecomunicaciones);
        interesTelematica=(CheckBox)findViewById(R.id.interes_telematica);
        interesCurso=(CheckBox)findViewById(R.id.interes_curso);

    }

    public void onStoryCheckBoxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.medio_e_mail:
                if(checked){
                    medioEmail.setChecked(true);
                }else{
                    medioEmail.setChecked(false);
                }
                break;
            case R.id.medio_web:
                if(checked){
                    medioWeb.setChecked(true);
                }else{
                    medioWeb.setChecked(false);
                }break;
            case R.id.medio_referencia:
                if(checked){
                    medioReferencia.setChecked(true);
                }else{
                    medioReferencia.setChecked(false);
                }break;
            case R.id.medio_papel:
                if(checked){
                    medioPapel.setChecked(true);
                }else{
                    medioPapel.setChecked(false);
                }break;
            case R.id.medio_radio:
                if(checked){
                    medioRadio.setChecked(true);
                }else{
                    medioRadio.setChecked(false);
                }break;
            case R.id.medio_tv:
                if(checked){
                    medioTV.setChecked(true);
                }else{
                    medioTV.setChecked(false);
                }break;
            case R.id.medio_feria:
                if(checked){
                    medioFeria.setChecked(true);
                }else{
                    medioFeria.setChecked(false);
                }break;
        }
    }
    //public void click(view)

    public void onInterestCheckBoxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.interes_telematica:
                if(checked){
                    interesTelematica.setChecked(true);
                }else{
                    interesTelematica.setChecked(false);
                }
                break;
            case R.id.interes_telecomunicaciones:
                if(checked){
                    interesTelecomunicaciones.setChecked(true);
                }else{
                    interesTelecomunicaciones.setChecked(false);
                }break;
            case R.id.interes_curso:
                if(checked){
                    interesCursoTexto.setEnabled(true);
                    interesCurso.setEnabled(true);
                }else{
                    interesCursoTexto.setEnabled(false);
                    interesCurso.setEnabled(false);
                }break;
        }
    }

    private String getLocalTime()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String horarioActual=dateFormat.format(cal.getTime()).toString();
        return horarioActual;
    }

    private String getGender(){
        String gender="";
        if (isMale.isChecked())gender="Hombre";
        if(isFemale.isChecked())gender="Mujer";
        return gender;
    }

    String preferencias(){
        String interes="";
        if (interesTelematica.isChecked())interes=interes+"Telematica/";
        if (interesTelecomunicaciones.isChecked())interes=interes+"Telecomunicaciones/";
        if (interesCurso.isChecked())interes=interes+interesCursoTexto.getText().toString();
        return interes;
    }

    String medios(){
        String medios="";
        if(medioEmail.isChecked())medios=medios+"E-mail/";
        if(medioWeb.isChecked())medios=medios+"Web/";
        if(medioReferencia.isChecked())medios=medios+"Referencias/";
        if(medioPapel.isChecked())medios=medios+"Papel/";
        if(medioRadio.isChecked())medios=medios+"Radio/";
        if(medioTV.isChecked())medios=medios+"TV/";
        if(medioFeria.isChecked())medios=medios+"Feria/";
        medios=medios+medioOtros.getText().toString();
        return medios;
    }

    private boolean checkObligatoryFields(){
        boolean chkNombres, chkApellidoPaterno,chkApellidoMaterno,chkDNI,chkDistrito,chkTelefonoCasa;
        boolean chkCelular, chkCorreoElectronico, chkPrefTelma,chkPrefTelcom, chkPrefCursos, chkCursosTipo;
        boolean veredict=false;


        chkNombres=nombresCompletos.getText().toString().isEmpty();
        chkApellidoPaterno=apellidoPaterno.getText().toString().isEmpty();
        chkApellidoMaterno=apellidoMaterno.getText().toString().isEmpty();
        chkDNI=numeroDNI.getText().toString().isEmpty();
        chkDistrito=distrito.getText().toString().isEmpty();
        chkTelefonoCasa=telefonoCasa.getText().toString().isEmpty();
        chkCelular=telefonoCelular.getText().toString().isEmpty();
        chkCorreoElectronico=correoElectronico.getText().toString().isEmpty();
        chkPrefTelma=interesTelematica.isChecked();
        chkPrefTelcom=interesTelecomunicaciones.isChecked();
        chkPrefCursos=interesCurso.isChecked();
        chkCursosTipo=interesCursoTexto.getText().toString().isEmpty();


        if (chkApellidoPaterno) {
            Toast.makeText(ClientRegistration.this, "Introduzca el apellido paterno", Toast.LENGTH_SHORT).show();
            return veredict;
        }else if( chkApellidoMaterno  ){
            Toast.makeText(ClientRegistration.this,"Introduzca el apellido materno" , Toast.LENGTH_SHORT).show();
            return veredict;
        }else if(chkNombres){
            Toast.makeText(ClientRegistration.this, "Introduzca el nombre", Toast.LENGTH_SHORT).show();
            return veredict;
        }else if(chkDNI){
            Toast.makeText(ClientRegistration.this, "Introduzca el número de DNI", Toast.LENGTH_SHORT).show();
            return veredict;
        }else if(chkDistrito){
            Toast.makeText(ClientRegistration.this, "Introduzca el Distrito", Toast.LENGTH_SHORT).show();
            return veredict;
        }else if(chkTelefonoCasa){
            Toast.makeText(ClientRegistration.this, "Introduzca el Teléfono de Fijo", Toast.LENGTH_SHORT).show();
            return veredict;
        }else if(chkCelular){
            Toast.makeText(ClientRegistration.this, "Introduzca el Teléfono de Celular", Toast.LENGTH_SHORT).show();
            return veredict;
        }else if(chkCorreoElectronico){
            Toast.makeText(ClientRegistration.this, "Introduzca el Correo Electrónico", Toast.LENGTH_SHORT).show();
            return veredict;
        }else if(!chkPrefCursos && !chkPrefTelcom && !chkPrefTelma){
            Toast.makeText(ClientRegistration.this, "Elija sus intereses", Toast.LENGTH_SHORT).show();
            return veredict;
        }else if(chkPrefCursos && chkCursosTipo){
            Toast.makeText(ClientRegistration.this, "Especifíque su curso", Toast.LENGTH_SHORT).show();
            return veredict;
        }else{
            veredict=true;
        }
        return veredict;
    }

    public void saveData(View view){
        boolean decider;
        decider=checkObligatoryFields();

        if (decider){
            //Toast.makeText(MainActivity.this, "Éxito!!!", Toast.LENGTH_SHORT).show();
            recordData();
        }
    }

    private void recordData(){

        //CAMPOS OBLIGATORIOS
        String fechaText;
        String nombresCompletosText, apellidoPaternoText,apellidoMaternoText,dniText,distritoText;
        String telefonoCasaText, celularText, correoElectronicoText, preferenciasText;
        String mediosText;

        //CAMPOS OPCIONALES
        String protoCadena;
        String institucionProcedenciaText,distritoProcedenciaText,tipoEventoText;
        String edadText,fechaNacimientoText,generoText;
        String domicilioText,provinciaText,departamentoText;


        //CAMPOS OBLIGATORIOS
        fechaText=lblFecha.getText().toString();
        nombresCompletosText=nombresCompletos.getText().toString();
        apellidoPaternoText=apellidoPaterno.getText().toString();
        apellidoMaternoText=apellidoMaterno.getText().toString();
        dniText=numeroDNI.getText().toString();
        distritoText=distrito.getText().toString();
        telefonoCasaText=telefonoCasa.getText().toString();
        celularText=telefonoCelular.getText().toString();
        correoElectronicoText=correoElectronico.getText().toString();
        preferenciasText=preferencias();

        //CAMPOS OPCIONALES
        institucionProcedenciaText=institucionProcedencia.getText().toString();
        distritoProcedenciaText=distritoProcedencia.getText().toString();
        tipoEventoText=tipoEvento.getText().toString();
        edadText=edad.getText().toString();
        fechaNacimientoText=fechaNacimiento.getText().toString();
        generoText=getGender();
        domicilioText=domicilio.getText().toString();
        provinciaText=provincia.getText().toString();
        departamentoText=departamento.getText().toString();
        mediosText=medios();

        String baseDir = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        String fileName = "AnalysisData.csv";
        String filePath = baseDir + File.separator + fileName;
        String FILENAME="data.csv";

        String header[]={"Fecha de Registro","Institucion de Procedencia","Distrito de Institución de Procedencia","Tipo de Evento"
                ,"Nombres","Apellido Paterno","Apellido Materno",
                "Edad","Sexo","Fecha de Nacimiento","DNI",
                "Domicilio","Distrito","Provincia","Departamento",
                "Telefono Fijo","Telefono Celular","E-mail","Medios","Intereses"};
        String finalString[]={fechaText,institucionProcedenciaText,distritoProcedenciaText,tipoEventoText,
                nombresCompletosText,apellidoPaternoText,apellidoMaternoText,
                edadText,generoText,fechaNacimientoText,dniText,
                domicilioText,distritoText,provinciaText,departamentoText,
                telefonoCasaText,celularText,correoElectronicoText,mediosText,preferenciasText};

        String cabecera[]={"Fecha de Registro","Nombres","Apellido Paterno","Apellido Materno","DNI","Distrito","Telefono Fijo","Telefono Celular","E-mail","Intereses"};
        String cadenaFinal[]={lblFecha.getText().toString(),nombresCompletosText,apellidoPaternoText,apellidoMaternoText,dniText,distritoText,telefonoCasaText,celularText,correoElectronicoText,preferenciasText};

        File f = new File(filePath );
        CSVWriter writer;
        try {
            if(f.exists()){
                Toast.makeText(ClientRegistration.this, "Información grabada en "+filePath.toString(), Toast.LENGTH_SHORT).show();
                FileWriter mFileWriter = new FileWriter(filePath, true);
                writer = new CSVWriter(mFileWriter);
                //writer.writeNext(cadenaFinal);
                writer.writeNext(finalString);
                writer.close();
            }else{
                Toast.makeText(ClientRegistration.this, "Información grabada en "+filePath.toString(), Toast.LENGTH_SHORT).show();
                writer=new CSVWriter(new FileWriter(filePath));
                //writer.writeNext(cabecera);
                //writer.writeNext(cadenaFinal);
                writer.writeNext(header);
                writer.writeNext(finalString);
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
