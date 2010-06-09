/*
 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Sun Microsystems nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package edu.austral.lab1.odontobook.graphicInterface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CheckBox {

    
    

    private JRadioButton redButton;
	private JRadioButton blueButton;
	private JRadioButton witheButton;

	public  JPanel CheckBox() {
       

        //Create the radio buttons.
         redButton = new JRadioButton("Rojo");
        redButton.setMnemonic(KeyEvent.VK_B);
        redButton.setActionCommand("Rojo");
        

         blueButton = new JRadioButton("Azul");
        blueButton.setMnemonic(KeyEvent.VK_C);
        blueButton.setActionCommand("Azul");

         witheButton = new JRadioButton("Blanco");
        witheButton.setMnemonic(KeyEvent.VK_D);
        witheButton.setActionCommand("Blanco");

     
        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(redButton);
        group.add(blueButton);
        group.add(witheButton);
      

        //Register a listener for the radio buttons.
         //Put the radio buttons in a column in a panel.
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(redButton);
        radioPanel.add(blueButton);
        radioPanel.add(witheButton);

      return radioPanel;
    }

       }   