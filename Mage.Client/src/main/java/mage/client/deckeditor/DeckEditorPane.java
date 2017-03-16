/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
 */

 /*
 * DeckEditorPane.java
 *
 * Created on Dec 17, 2009, 9:21:42 AM
 */
package mage.client.deckeditor;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.swing.JComponent;
import mage.cards.decks.Deck;
import mage.client.MagePane;
import mage.client.constants.Constants.DeckEditorMode;
import mage.client.plugins.impl.Plugins;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class DeckEditorPane extends MagePane {

    /**
     * Creates new form TablesPane
     */
    public DeckEditorPane() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        boolean initialized = false;
        if (Plugins.instance.isThemePluginLoaded()) {
            Map<String, JComponent> uiMap = new HashMap<>();
            JComponent container = Plugins.instance.updateTablePanel(uiMap);
            if (container != null) {
                deckEditorPanel1 = new mage.client.deckeditor.DeckEditorPanel();
                initComponents(container);
                container.add(deckEditorPanel1);
                container.setOpaque(false);
                deckEditorPanel1.setOpaque(false);
                initialized = true;
            }
        }
        if (!initialized) {
            initComponents();
        }
    }

    @Override
    public void changeGUISize() {
        super.changeGUISize();
        deckEditorPanel1.changeGUISize();
    }

    public void show(DeckEditorMode mode, Deck deck, String name, UUID tableId, int time) {
        if (mode == DeckEditorMode.SIDEBOARDING || mode == DeckEditorMode.LIMITED_BUILDING) {
            this.setTitle("Deck Editor - " + tableId.toString());
        } else if (deck != null) {
            this.setTitle("Deck Editor - " + deck.getName());
        } else {
            this.setTitle("Deck Editor");
        }
        this.deckEditorPanel1.showDeckEditor(mode, deck, tableId, time);
        this.repaint();
    }

    public DeckEditorMode getDeckEditorMode() {
        return this.deckEditorPanel1.getDeckEditorMode();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deckEditorPanel1 = new mage.client.deckeditor.DeckEditorPanel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deckEditorPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deckEditorPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initComponents(Component container) {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );

        pack();
    }

    public DeckEditorPanel getPanel() {
        return deckEditorPanel1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mage.client.deckeditor.DeckEditorPanel deckEditorPanel1;
    // End of variables declaration//GEN-END:variables

}
