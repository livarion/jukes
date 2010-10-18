package com.melloware.jukes.gui.view.component;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.melloware.jukes.db.orm.Track;
import com.melloware.jukes.gui.tool.Settings;

/**
 * Custom PlaylistCellRenderer used to display playlist Tracks in JList.
 * <p>
 * Copyright (c) 1999-2007 Melloware, Inc. <http://www.melloware.com>
 * @author Emil A. Lefkof III <info@melloware.com>
 * @version 4.0
 */
public final class PlaylistCellRenderer
    extends JLabel
    implements ListCellRenderer {

    public final Settings settings;

    /**
     * Default Constructor
     */
    public PlaylistCellRenderer() {
        super();
        this.settings = null;
    }

    /**
     * Default Constructor
     */
    public PlaylistCellRenderer(Settings aSettings) {
        super();
        this.settings = aSettings;
    }

    /* (non-Javadoc)
     * @see javax.swing.ListCellRenderer#getListCellRendererComponent(javax.swing.JList, java.lang.Object, int, boolean,
     * boolean)
     */
    public Component getListCellRendererComponent(final JList list,
                                                  final Object value,
                                                  final int index,
                                                  final boolean isSelected,
                                                  final boolean cellHasFocus) {

        final Track track = (Track)value;

        // pad the display with two spaces for readability
        final StringBuffer sbText = new StringBuffer();
        sbText.append(' ');
        sbText.append(track.getDisc().getArtist().getName());
        sbText.append(" - ");
        sbText.append(track.getName());
        sbText.append("  (");
        sbText.append(track.getDurationTime());
        sbText.append(") ");
        this.setText(sbText.toString());
        
        // set the tooltip text
        final StringBuffer sbTooltip = new StringBuffer();
        sbTooltip.append(' ');
        sbTooltip.append(track.getDisc().getArtist().getName());
        sbTooltip.append(" - ");
        sbTooltip.append(track.getDisc().getName());
        sbTooltip.append(" - ");
        sbTooltip.append(track.getName());
        sbTooltip.append("  [");
        sbTooltip.append(track.getDurationTime());
        sbTooltip.append("] ");
        this.setToolTipText(sbTooltip.toString());
        
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        setOpaque(true);
        return this;
    }

}