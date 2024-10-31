package co.uniquindio.proyectoestructuradedatos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginApp extends Application {
    private GestorUsuarios gestorUsuarios;

//----------------------------------------------------------------------------------------------------------------------
    //ESPECIFICACIONES DE LA INTERFAZ:
//----------------------------------------------------------------------------------------------------------------------

    @Override
    public void start(Stage primaryStage) {
        gestorUsuarios = new GestorUsuarios();

        Label tituloLabel = new Label("Bienvenido");
        tituloLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        Label lblUsuario = new Label("Usuario:");
        TextField txtUsuario = new TextField();

        Label lblPassword = new Label("Contraseña:");
        PasswordField txtPassword = new PasswordField();

        Label lblMensaje = new Label();
        lblMensaje.setTextFill(Color.RED);

        Button btnIniciarSesion = new Button("Iniciar Sesión");

        btnIniciarSesion.setOnAction(event -> {
            String usuario = txtUsuario.getText();
            String contrasenia = txtPassword.getText();
            Usuario usuarioAutenticado = gestorUsuarios.autenticar(usuario, contrasenia);

            if (usuarioAutenticado != null) {
                lblMensaje.setText("El usuario " + usuarioAutenticado.getRol() + " Ha iniciado sesión correctamente!");
                if (usuarioAutenticado.getRol() == Rol.ADMINISTRADOR) {
                    mostrarOpcionesAdministrador();
                } else {
                    mostrarOpcionesUsuario();
                }
            } else {
                lblMensaje.setText("El Usuario o la contraseña fué ingresada mal :(");
            }
        });


        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);

        // Añadir los elementos al layout
        layout.add(tituloLabel, 0, 0, 2, 1); // Título en la primera fila, centrado en dos columnas
        layout.add(lblUsuario, 0, 1);
        layout.add(txtUsuario, 1, 1);
        layout.add(lblPassword, 0, 2);
        layout.add(txtPassword, 1, 2);
        layout.add(lblMensaje, 0, 3, 2, 1);
        layout.add(btnIniciarSesion, 1, 4);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("INICIO DE SESIÓN");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//----------------------------------------------------------------------------------------------------------------------
    // METODOS IMPORTANTES PARA LA APLICACIÓN:
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------

    private void mostrarOpcionesAdministrador() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Opciones de Administrador");
        alert.setHeaderText("Hola Administrador");
        alert.setContentText("Aquí se tiene acceso a opciones de administrador, como la creación de procesos ;)");
        alert.showAndWait();
    }

//----------------------------------------------------------------------------------------------------------------------

    private void mostrarOpcionesUsuario() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Opciones de Usuario Normal");
        alert.setHeaderText("Hola Usuario");
        alert.setContentText("Aquí se tiene acceso a opciones disponibles para usuarios normales ;)");
        alert.showAndWait();
    }

//----------------------------------------------------------------------------------------------------------------------
    //Ejecutar la app
    public static void main(String[] args) {
        launch(args);
    }
}
