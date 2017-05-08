package com.example.gusta.marvelcomics.util;

/**
 * Created by gusta on 06/05/2017.
 */

public class Constant {

    /*Credentials*/
    public static final String PUBLIC_KEY = "464cf34c19c8aff897cc63fed0e21669";
    public static final String PRIVATE_KEY = "01e87652f0747b797ff1465ba64260d7bd242532";

    /*url*/
    public static final String URL = "https://gateway.marvel.com:443/v1/public";
    public static final String URL_CHARACTER = URL + "/characters?ts=%1$s&limit=%2$s&offset=%3$s&apikey=%4$s&hash=%5$s";

    /*WebService*/

    public static final String WS_CONTENT_TYPE = "Content-Type";
    public static final String WS_APPLICATION_JSON = "application/json";
    public static final String WS_ACCEPT = "Accept";
    public static final String WS_CONTENT_TYPE_TEXT = "text/json";

    public static final int CIDADAO_PLATAFORMA_ANDROID = 1;
    public static final int CIDADAO_TIPO_MIDIA_GOOGLE = 1;
    public static final int CIDADAO_TIPO_MIDIA_FACEBOOK = 2;
    public static final int CIDADAO_TIPO_MIDIA_TWITTER = 3;

    public static final String REQUEST_METHOD_GET = "GET";
    public static final String REQUEST_METHOD_POST = "POST";
    public static final String REQUEST_PROPERTY_AUTHORIZATION = "Authorization";
    public static final String REQUEST_PROPERTY_CONTENT_LENGHT = "Content-Length";
    public static final int READ_TIMEOUT = 10000;
    public static final int CONNECT_TIMEOUT = 15000;

    /*Message*/
    public static final String HTTP_PROBLEM = "Problemas na consulta do servidor";


}
