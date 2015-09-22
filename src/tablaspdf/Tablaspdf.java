
package tablaspdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JFrame;



 public class Tablaspdf extends JFrame{

         
         
        public void Tablaspdf() throws DocumentException, FileNotFoundException{    
          // se crea instancia del documento
         Document mipdf = new Document();
         // se establece una instancia a un documento pdf
         int ind=1;
         PdfWriter.getInstance(mipdf, new FileOutputStream(new File("G:/tablas ("+ind+").pdf")));
         ind=ind+1;
         mipdf.open(); // se abre el documento
             
         mipdf.addTitle("Tablas con itext"); // se añade el 
         
         mipdf.addAuthor("jc mouse"); // se añade el autor del documento
         
         mipdf.addSubject("ocio"); //se añade el asunto del documento
         
         mipdf.addKeywords("jc mouse"); //Se agregan palabras claves    
         
         
        /* ahora si tablas */           
         mipdf.add(Tabla_Simple());
         mipdf.add(Tabla_compleja());
         mipdf.close(); //se cierra el PDF               
         System.out.println("documento pdf creado");
     }

    
             
    public PdfPTable Tabla_Simple(){    
         //creamos la tabla con 3 columnas
        System.out.println("TABLA SIMPLE");
         PdfPTable mitablasimple=new PdfPTable(3);
         //añadimos contenido a las celdas
         
         mitablasimple.addCell("Enero");
         mitablasimple.addCell("Febrero");
         mitablasimple.addCell("Marzo");
         mitablasimple.addCell("Abril");
         mitablasimple.addCell("Mayo");
         mitablasimple.addCell("Junio");
         mitablasimple.addCell("Julio");
         mitablasimple.addCell("Agosto");
         mitablasimple.addCell("Septiembre");
         mitablasimple.addCell("Octubre");
         //retornamos la tabla
         return mitablasimple;        
     }
     
     public PdfPTable Tabla_compleja(){ 
         //creamos una tabla con 3 columnas
         System.out.println("TABLA COMPLEJA");
         PdfPTable mitablacompleja=new PdfPTable(3);
         //añadimos texto con formato a la primera celda
         PdfPCell celda =new PdfPCell (new Paragraph("Historial de Observaciones",
                 FontFactory.getFont("comic sans",   // fuente
                 22,                            // tamaño
                 Font.BOLD,                   // estilo
                 BaseColor.RED)));             // color
         //unimos esta celda con otras 2
         celda.setColspan(3);
         //alineamos el contenido al centro
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         // añadimos un espaciado
         celda.setPadding (12.0f);
         //colocamos un color de fondo
         celda.setBackgroundColor(BaseColor.GRAY);
         //se añade a la tabla
         mitablacompleja.addCell(celda);
         
         //fila 2
         celda = new PdfPCell(new Paragraph ("AUDITORIA DE SISTEMAS"));
         celda.setColspan(2);
         celda.setBackgroundColor(BaseColor.GREEN);
         mitablacompleja.addCell(celda);        
         celda = new PdfPCell(new Paragraph ("Aprobado"));        
         celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
         mitablacompleja.addCell(celda);
         //fila 3        
         celda = new PdfPCell(new Paragraph ("COMPILADORES"));
         celda.setColspan(2);
         celda.setBackgroundColor(BaseColor.YELLOW);
         mitablacompleja.addCell(celda);        
         celda = new PdfPCell(new Paragraph ("Reprobado"));        
         celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
         mitablacompleja.addCell(celda);
         //fila 4        
         celda = new PdfPCell(new Paragraph ("Prog. Bajo Nivel"));
         celda.setColspan(2);
         celda.setBackgroundColor(BaseColor.CYAN);
         mitablacompleja.addCell(celda);        
         celda = new PdfPCell(new Paragraph ("Eximido"));        
         celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
         mitablacompleja.addCell(celda);
         //fila 5
         mitablacompleja.addCell("Conclusion");
         celda = new PdfPCell(new Paragraph ("¡¡¡GET A LIFE!!!"));
         celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
         celda.setColspan(2);
         celda.setBackgroundColor(BaseColor.ORANGE);
         mitablacompleja.addCell(celda);
         // se retorna la tabla
         return mitablacompleja;    
     }
     public static void main(String [] args) throws DocumentException, FileNotFoundException
     {
     Tablaspdf a=new Tablaspdf();
   a.Tablaspdf()  ;
     }
 }
