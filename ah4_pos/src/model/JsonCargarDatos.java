
package model;

import com.google.gson.Gson;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sucursales.Sucursales;

public class JsonCargarDatos {
    
    
//     private void creardoc() {
//        String fileName = "sucursales.txt";
//        String content = "Este es un ejemplo de archivo de texto creado en Java.";
//
//        try {
//            // Crear el objeto FileWriter
//            FileWriter fileWriter = new FileWriter(fileName);
//
//            // Crear el objeto BufferedWriter
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
//            // Escribir el contenido en el archivo
//            bufferedWriter.write(content);
//
//            // Cerrar el BufferedWriter
//            bufferedWriter.close();
//
//            System.out.println("Archivo de texto creado exitosamente: " + fileName);
//        } catch (IOException e) {
//            System.out.println("Error al crear el archivo de texto.");
//            e.printStackTrace();
//        }
//
//    }

//    public void crearjson() {
//        String json = "[";
//        
//        for (int i = 0; i < 5; i++) {
//            // Crear un objeto de tipo Persona
//            Sucursales us = new Sucursales();
//
//            // Crear un objeto Gson
//            Gson gson = new Gson();
//
//            if (i < 4) {
//
//                // Convertir el objeto 'persona' en una cadena JSON
//                json += "," + gson.toJson(us);
//            } else {
//
//                // Convertir el objeto 'persona' en una cadena JSON
//                json += gson.toJson(us);
//
//            }
//
//        }
//
//        json += "]";
//
//        // Imprimir la representación JSON
//        System.out.println(json);
//    }

    public String leerarchivo() {
        JFileChooser fc = new JFileChooser();
        JPanel datos = new JPanel();
        int op = fc.showOpenDialog(datos);
        String content = "";
        if (op == JFileChooser.APPROVE_OPTION) {
            File pRuta = fc.getSelectedFile();
            String ruta = pRuta.getAbsolutePath();
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            
            try {
                archivo = new File(ruta);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String linea = "";

                while ((linea = br.readLine()) != null) {
                    content += linea + "\n";
                }
                return content;

            } catch (FileNotFoundException ex) {
                JOptionPane.showInputDialog(null, "No se encontro el archivo");
            } catch (IOException ex) {
                JOptionPane.showInputDialog(null, "No se pudo abrir el archivo");
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    JOptionPane.showInputDialog(null, "No se encontro el archivo");
                    return "";
                }
            }
            return content;
        }
        return null;
    }
    
//    public void generar_pdf() throws FileNotFoundException, DocumentException {
//        FileOutputStream gen = new FileOutputStream("Ejemplo.pdf");
//        Document documento = new Document();
//
//        PdfWriter.getInstance(documento, gen);
//        documento.open();
//
//        Paragraph parrafo = new Paragraph("Bienvenido");
//        parrafo.setAlignment(1);
//        documento.add(parrafo);
//        documento.add(new Paragraph("\n"));
//
//        String texto = "a";
//        documento.add(new Paragraph(texto));
//        documento.close();
//        JOptionPane.showMessageDialog(null, "El archivo se creo correctamente");
//        try {
//            File sucursales_doc = new File("Ejemplo.pdf");
//            Desktop.getDesktop().open(sucursales_doc);
//        } catch (Exception e) {
//        }
//    }
}
