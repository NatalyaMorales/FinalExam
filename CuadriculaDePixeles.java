package example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CuadriculaDePixeles {

    public static void main(String[] args) {
        // Cargar imagen original
        String ruta = "C:/Users/Amigu/Downloads/pato.jpg";
        ImageIcon imagenOriginal = new ImageIcon(ruta);
        Image imagen = imagenOriginal.getImage();
        
        // Convertir imagen a BufferedImage
        BufferedImage buffered = new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        buffered.getGraphics().drawImage(imagen, 0, 0, null);
        
        int sizeA=10;
        int sizeB=10;

        // Dividir imagen en una cuadrícula de 5x5
        int anchoCelda = imagen.getWidth(null) / sizeA;
        int alturaCelda = imagen.getHeight(null) / sizeB;
        JLabel[][] etiquetas = new JLabel[sizeA][sizeB];
        JPanel panel = new JPanel(new GridLayout(sizeA, sizeB));
        Border borde = BorderFactory.createLineBorder(Color.BLACK, 1);
        for (int i = 0; i < sizeA; i++) {
            for (int j = 0; j < sizeB; j++) {
                int x = j * anchoCelda;
                int y = i * alturaCelda;
                BufferedImage subimagen = buffered.getSubimage(x, y, anchoCelda, alturaCelda);
                ImageIcon imagenCelda = new ImageIcon(subimagen);
                etiquetas[i][j] = new JLabel(imagenCelda);
                etiquetas[i][j].setBorder(borde);
                panel.add(etiquetas[i][j]);
            }
        }
        
        // Crear ventana y agregar panel
        JFrame ventana = new JFrame();
        ventana.add(panel);
        ventana.pack();
        ventana.setVisible(true);
    }

}
