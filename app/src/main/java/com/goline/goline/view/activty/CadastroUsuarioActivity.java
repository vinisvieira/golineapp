package com.goline.goline.view.activty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.goline.goline.R;
import com.goline.goline.model.entity.Paciente;
import com.goline.goline.util.AlertUtil;
import com.goline.goline.util.EncryptUtil;
import com.goline.goline.util.HttpHelper;
import com.goline.goline.util.LogUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class CadastroUsuarioActivity extends AppCompatActivity implements FirebaseAuth.AuthStateListener{

    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private String uid;

    private CallbackManager callbackManager;
    private LoginButton loginButton;

    private EditText editNome;
    private EditText editEmail;
    private EditText editTelefone;
    private EditText editPassword;

    private ProgressDialog progressDialog;

    private HttpHelper httpHelper = new HttpHelper ("http://192.168.23.47:8080/goline_2.0/api");
   // ("http://192.168.25.5:8080/goline_2.0/api");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);


        loginButton = (LoginButton) findViewById(R.id.cadastro_button);
        loginButton.setReadPermissions("email", "public_profile");
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

                AlertUtil.toast(getBaseContext(), "Erro...");
                error.printStackTrace();
            }
        });

        ActionBar actionBar = getSupportActionBar();

        // Método que ativa o botão Up Navigation
        actionBar.setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();

        editNome = (EditText) findViewById(R.id.nomeEditTxt);
        editEmail = (EditText) findViewById(R.id.emailEditTxt);
        editTelefone = (EditText) findViewById(R.id.telefoneEditTxt);
        editPassword = (EditText) findViewById(R.id.senhaEditTxt);

        progressDialog = AlertUtil.getProgressDialog(this, "Verificando credenciais",
                "Aguarde um momento");
    }

    @Override
    public void onStart(){
        super.onStart();
        firebaseAuth.addAuthStateListener(this);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        firebaseAuth.removeAuthStateListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void handleFacebookAccessToken(AccessToken accessToken) {
        progressDialog.show();
        final AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (!task.isSuccessful()) {
                    AlertUtil.toast(getBaseContext(), "Erro...");
                }

                user = firebaseAuth.getCurrentUser();

                uid = user.getUid();
                String nome = user.getDisplayName();
                String email = user.getEmail();

                Paciente paciente = new Paciente();

                paciente.setNome(nome);
                paciente.setEmail(email);
                paciente.setToken(uid);

                new CadastroPacienteAsyncTask().execute(paciente);

            }
        });
    }

    public void signIn(View view) {
        if(editEmail.getText().toString().trim().equals("")){
            AlertUtil.toast(getBaseContext(), "Informe o e-mail de usuário");
        }else if(editPassword.getText().toString().trim().equals("")){
            AlertUtil.toast(getBaseContext(), "Informe a senha de usuário");
        }else{
            progressDialog.show();

            String email = editEmail.getText().toString();
            String password = editPassword.getText().toString();
            password = EncryptUtil.encryptPassword(password);

            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();

                    if(!task.isSuccessful()){
                        if(task.getException() instanceof FirebaseAuthInvalidCredentialsException){
                            AlertUtil.toast(getBaseContext(), "E-mail inválido");
                        }else if(task.getException() instanceof FirebaseAuthUserCollisionException){
                            AlertUtil.toast(getBaseContext(), "Já existe um usuário inscrito com o e-mail informado");
                        }else{
                            AlertUtil.toast(getBaseContext(), "Ocorreu um erro. Tente Novamente.");
                        }
                    }

                    user = firebaseAuth.getCurrentUser();

                    uid = user.getUid();
                    String nome = editNome.getText().toString();
                    String email = editEmail.getText().toString();
                    String telefone = editTelefone.getText().toString();
                    String senha = editPassword.getText().toString();

                    Paciente paciente = new Paciente();

                    paciente.setNome(nome);
                    paciente.setEmail(email);
                    paciente.setTelefone(telefone);
                    paciente.setPassword(senha);
                    paciente.setToken(uid);

                    new CadastroPacienteAsyncTask().execute(paciente);
                }
            });
        }
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        user = firebaseAuth.getCurrentUser();

        if(user!=null){

            Toast.makeText(this, "Usuário logado... ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }else{
            //Toast.makeText(this, "Usuário não logado", Toast.LENGTH_SHORT).show();
        }
    }

class CadastroPacienteAsyncTask extends AsyncTask<Paciente, Void, String>{

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        progressDialog.show();
    }

    @Override
    protected String doInBackground(Paciente... pacientes) {
        Paciente paciente = pacientes[0];
        Gson gson = new Gson();
        String body = gson.toJson(paciente);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=utf-8");
        String response = httpHelper.doPOST("paciente",  headers, body);
        return response;
    }

    @Override
    protected void onPostExecute(String response){
        super.onPostExecute(response);
        progressDialog.dismiss();

    }
}
    // Esse método da Activity é chamado sempre que um botão da ActionBar é clicado
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Estou verificando pelo Id do botão clicado se corresponde ao botão Up Navigation
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

