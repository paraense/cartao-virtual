/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jid.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import static java.lang.System.out;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author John
 */

public class SmsSercive {

    private static final String CREDENCIAL = "DE44F60F26ECC8FA5D16854E3ED21473121C3CC0";
    private static final String TOKEN = "d56308";
    private static final String APP = "CartaoVirtual";
    private static final String USER = "JOHNGOMEZ";

   
    public static void enviaSms(String mensagem, String celular) throws UnsupportedEncodingException, MalformedURLException, IOException {
        String Credential = URLEncoder.encode(CREDENCIAL);
        String Token = URLEncoder.encode(TOKEN);
        String MainUser = URLEncoder.encode(APP);
        String AuxUser = URLEncoder.encode("AUX1");
        String Mobile = URLEncoder.encode("55" + celular);
        String SendProject = URLEncoder.encode("N");

        String Msg = mensagem;
        Msg = URLEncoder.encode(Msg, "UTF-8");

        String connection
                = "https://www.mpgateway.com/v_3_00/sms/smspush/enviasms.aspx?CREDENCIAL="
                + Credential + "&TOKEN=" + Token + "&PRINCIPAL_USER=" + MainUser + "&AUX_USER=" + AuxUser + "&MOBILE=" + Mobile
                + "&SEND_PROJECT=" + SendProject + "&MESSAGE=" + Msg;

        URL url = new URL(connection);
        InputStream input = url.openStream();
        byte[] b = new byte[4];
        input.read(b, 0, b.length);
        String RetornoMPG = new String(b);
        out.println("Retorno = " + RetornoMPG);
    }

}
