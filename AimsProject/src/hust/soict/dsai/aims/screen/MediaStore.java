package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.exception.LimitException;
import hust.soict.dsai.aims.exception.PlayerException;

public class MediaStore extends JPanel{
    private Media media;

    public MediaStore(Media media){
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JLabel category = new JLabel("" + media.getCategory());
        category.setAlignmentX((CENTER_ALIGNMENT));

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addCart = new JButton("Add to cart");
        addCart.addActionListener(new AddCartButton());
        container.add(addCart);

        if(media instanceof Playable){
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new PlayBtnListener());
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(category);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class PlayBtnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			try {
                JOptionPane.showMessageDialog(null, ((Playable)media).play().toString());
            } catch (PlayerException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), e1.toString(), JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
            }
		}
	}

    private class AddCartButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            try {
                StoreScreen.cart.addMedia(media);
                JOptionPane.showMessageDialog(null, "Adding successful");
            } catch (LimitException e) {
                e.printStackTrace();;
            }
        }
    }
}
