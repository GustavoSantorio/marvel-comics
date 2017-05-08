package com.example.gusta.marvelcomics.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;

import com.example.gusta.marvelcomics.R;

/**
 * Created by gusta on 06/05/2017.
 */

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class Alert {
    /**
     * Enum criado para formalizar os diversos tipos de alertas que podem ser
     * mostrados.
     *
     */
    public enum AlertType {
        INFO(android.R.drawable.ic_dialog_info, "Informação"), WARN(
                android.R.drawable.ic_dialog_alert, "Alerta"), SUCESS(
                android.R.drawable.checkbox_on_background, "Sucesso"), ERROR(
                android.R.drawable.ic_delete, "Erro");

        // numero inteiro que guarda o valor do icone que sera mostrado no
        // dialog
        private int drawable;

        // T�tulo do dialog
        private String title;

        AlertType(int drawable, String title) {
            this.drawable = drawable;
            this.title = title;
        }

        public int getDrawable() {
            return this.drawable;
        }

        public String getTitle() {
            return this.title;
        }
    }

    /**
     * Mostra um dialog simples com um botao OK
     *
     * @param message
     *            mensagem/conteudo que aparecera no dialog
     * @param context
     *            contexto da aplicacao
     * @param alertType
     *            tipo de alerta(INFO, WARN, SUCESS, ERROR)
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void showSimpleDialog(String message, Context context,
                                        AlertType alertType) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage(message);
        alertDialog.setNeutralButton("OK", null);

        alertDialog.setInverseBackgroundForced(true);

        if (alertType == null) {
            alertDialog.setIcon(android.R.drawable.ic_dialog_info);
            alertDialog.setTitle(AlertType.INFO.getTitle());
        } else {
            alertDialog.setIcon(alertType.getDrawable());
            alertDialog.setTitle(alertType.getTitle());
        }
        alertDialog.show();
    }

    /**
     * Mostra um dialog simples com um botao OK, com acao ao clicar no OK
     *
     * @param message
     *            mensagem/conteudo que aparecera no dialog
     * @param context
     *            contexto da aplicacao
     * @param alertType
     *            tipo de alerta(INFO, WARN, SUCESS, ERROR)
     * @param okButton
     *            acao do botao ok
     */
    public static void showSimpleDialog(String message, Context context,
                                        AlertType alertType, DialogInterface.OnClickListener okButton) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage(message);
        alertDialog.setNeutralButton("OK", okButton);
        if (alertType == null) {
            alertDialog.setIcon(android.R.drawable.ic_dialog_info);
            alertDialog.setTitle(AlertType.INFO.getTitle());
        } else {
            alertDialog.setIcon(alertType.getDrawable());
            alertDialog.setTitle(alertType.getTitle());
        }
        alertDialog.show();
    }

    /**
     * Mostra um dialog com um botao Sim e um botao Nao, com acao no botao Sim e
     * outra acao no botao Nao
     *
     * @param message
     *            mensagem/conteudo que aparecera no dialog
     * @param context
     *            contexto da aplicacao
     * @param yesButton
     *            acao do botao Sim
     * @param noButton
     *            acao do botao Nao
     * @param alertType
     *            tipo de alerta(INFO, WARN, SUCESS, ERROR)
     */
    public static void showYesNoDialog(String message, Context context,
                                       DialogInterface.OnClickListener yesButton, DialogInterface.OnClickListener noButton,
                                       AlertType alertType) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton("Sim", yesButton);
        alertDialog.setNegativeButton("Não", noButton);
        if (alertType == null) {
            alertDialog.setIcon(android.R.drawable.ic_dialog_info);
            alertDialog.setTitle(AlertType.INFO.getTitle());
        } else {
            alertDialog.setIcon(alertType.getDrawable());
            alertDialog.setTitle(alertType.getTitle());
        }
        alertDialog.show();
    }

    /**
     * Mostra um dialog com um botao Sim e um botao Nao, com acao somente no
     * botao Sim
     *
     * @param message
     *            mensagem/conteudo que aparecera no dialog
     * @param context
     *            contexto da aplicacao
     * @param yesButton
     *            acao do botao Sim
     * @param alertType
     *            tipo de alerta(INFO, WARN, SUCESS, ERROR)
     */
    public static void showYesNoDialog(String message, Context context,
                                       DialogInterface.OnClickListener yesButton, AlertType alertType) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton("Sim", yesButton);
        alertDialog.setNegativeButton("Não", null);
        if (alertType == null) {
            alertDialog.setIcon(android.R.drawable.ic_dialog_info);
            alertDialog.setTitle(AlertType.INFO.getTitle());
        } else {
            alertDialog.setIcon(alertType.getDrawable());
            alertDialog.setTitle(alertType.getTitle());
        }
        alertDialog.show();
    }

    /**
     * Mostra um dialog com um botao Ok e um botao Cancelar, com acao ao clicar
     * no botao Ok e outra acao ao clicar em Cancelar
     *
     * @param message
     *            mensagem/conteudo que aparecera no dialog
     * @param context
     *            contexto da aplicacao
     * @param okButton
     *            acao do botao Ok
     * @param cancelButton
     *            acao do botao Cancelar
     * @param alertType
     *            tipo de alerta(INFO, WARN, SUCESS, ERROR)
     */
    public static void showConfirmDialog(String message, Context context,
                                         DialogInterface.OnClickListener okButton, DialogInterface.OnClickListener cancelButton,
                                         AlertType alertType) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton("Ok", okButton);
        alertDialog.setNegativeButton("Cancelar", cancelButton);
        if (alertType == null) {
            alertDialog.setIcon(android.R.drawable.ic_dialog_info);
            alertDialog.setTitle(AlertType.INFO.getTitle());
        } else {
            alertDialog.setIcon(alertType.getDrawable());
            alertDialog.setTitle(alertType.getTitle());
        }
        alertDialog.show();
    }

    /**
     * Mostra um dialog com um botao Ok e um botao Cancelar, com acao somente no
     * botao Ok
     *
     * @param message
     *            mensagem/conteudo que aparecera no dialog
     * @param context
     *            contexto da aplicacao
     * @param okButton
     *            acao do botao Ok
     * @param alertType
     *            tipo de alerta(INFO, WARN, SUCESS, ERROR)
     */
    public static void showConfirmDialog(String message, Context context,
                                         DialogInterface.OnClickListener okButton, AlertType alertType) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton("Ok", okButton);
        alertDialog.setNegativeButton("Cancelar", null);
        if (alertType == null) {
            alertDialog.setIcon(android.R.drawable.ic_dialog_info);
            alertDialog.setTitle(AlertType.INFO.getTitle());
        } else {
            alertDialog.setIcon(alertType.getDrawable());
            alertDialog.setTitle(alertType.getTitle());
        }
        alertDialog.show();
    }

}