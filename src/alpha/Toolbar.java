/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha;

import com.googlecode.javacv.FrameGrabber.Exception;
import edsdk.utils.CanonCamera;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

/**
 *
 * @author Christopher Williams
 */
public class Toolbar {

    final JMenuBar toolBar = new JMenuBar();
    //Settings
    JMenuItem vidsets = new JMenuItem("Video Settings");
    JMenuItem cam = new JMenuItem("Camera Settings");
    JMenuItem soundsettings = new JMenuItem("Audio Settings");
    //File
    JMenuItem openfile = new JMenuItem("Open Project");
    JMenuItem scene = new JMenuItem("New Scene");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem saveas = new JMenuItem("New Project");
    JMenuItem exit = new JMenuItem("exit");
    JMenuItem export = new JMenuItem("Export");
    //Tools
    JMenuItem capwin = new JMenuItem("Capture Window");
    JMenuItem photo = new JMenuItem("Image Editor");
    JMenuItem video = new JMenuItem("Video Editor");
    //Help
    JMenuItem about = new JMenuItem("About...");
    JMenuItem mshelp = new JMenuItem("Help");

    public Toolbar() {

        toolBar.add(createMoreButton());
        toolBar.add(createPrograms());
        toolBar.add(createSettings());
        toolBar.add(createHelp());

        actionMethod();
    }

    //Settings menu
    private AbstractButton createSettings() {
        final JToggleButton settingsButton = new JToggleButton("Settings");
        settingsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        settingsButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    createSettingsMenu((JComponent) e.getSource(), settingsButton);
                }
            }
        });
        settingsButton.setFocusable(false);
        settingsButton.setHorizontalTextPosition(SwingConstants.LEADING);
        return settingsButton;
    }

    //Help menu
    private AbstractButton createHelp() {
        final JToggleButton helpButton = new JToggleButton("Help");
        helpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        helpButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    createHelpMenu((JComponent) e.getSource(), helpButton);
                }
            }
        });
        helpButton.setFocusable(false);
        helpButton.setHorizontalTextPosition(SwingConstants.LEADING);
        return helpButton;
    }

    //File menu
    private AbstractButton createMoreButton() {
        final JToggleButton moreButton = new JToggleButton("File");
        moreButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        moreButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    createAndShowMenu((JComponent) e.getSource(), moreButton);
                }
            }
        });
        moreButton.setFocusable(false);
        moreButton.setHorizontalTextPosition(SwingConstants.LEADING);
        return moreButton;
    }

    //Tools menu
    private AbstractButton createPrograms() {
        final JToggleButton programs = new JToggleButton("Tools");
        programs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        programs.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    createProgramsMenu((JComponent) e.getSource(), programs);
                }
            }
        });
        programs.setFocusable(false);
        programs.setHorizontalTextPosition(SwingConstants.LEADING);
        return programs;
    }

    //Help menu list
    private void createHelpMenu(final JComponent component, final AbstractButton moreButton) {
        JPopupMenu menu = new JPopupMenu();
        menu.add(about);
        menu.add(mshelp);

        menu.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                moreButton.setSelected(false);
            }

            public void popupMenuCanceled(PopupMenuEvent e) {
                moreButton.setSelected(false);
            }
        });

        menu.show(component, 0, component.getHeight());
    }

    //Settings menu list
    private void createSettingsMenu(final JComponent component, final AbstractButton moreButton) {
        JPopupMenu menu = new JPopupMenu();
        menu.add(vidsets);
        menu.add(cam);
        menu.add(soundsettings);

        menu.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                moreButton.setSelected(false);
            }

            public void popupMenuCanceled(PopupMenuEvent e) {
                moreButton.setSelected(false);
            }
        });

        menu.show(component, 0, component.getHeight());
    }

    //File menu list
    private void createAndShowMenu(final JComponent component, final AbstractButton moreButton) {
        JPopupMenu menu = new JPopupMenu();
        menu.add(openfile);
        menu.add(save);
        menu.add(saveas);
        menu.add(scene);
        menu.add(export);
        menu.add(exit);

        menu.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                moreButton.setSelected(false);
            }

            public void popupMenuCanceled(PopupMenuEvent e) {
                moreButton.setSelected(false);
            }
        });

        menu.show(component, 0, component.getHeight());
    }

    //Programs menu list
    private void createProgramsMenu(final JComponent component, final AbstractButton programs) {
        JPopupMenu menu = new JPopupMenu();
        menu.add(capwin);
        menu.add(photo);
        menu.add(video);

        menu.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                programs.setSelected(false);
            }

            public void popupMenuCanceled(PopupMenuEvent e) {
                programs.setSelected(false);
            }
        });

        menu.show(component, 0, component.getHeight());
    }

    //Actions performed when clicked
    private void actionMethod() {

        scene.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                Save_Algorithm.newScene();
            }
        });


        openfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //add TODO code
            }
        });

        capwin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //Camera cam = new Camera();
            }
        });

        vidsets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                VideoSettings vs = new VideoSettings();
            }
        });

        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //add TODO code
            }
        });

        mshelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Help help = new Help();
            }
        });

        photo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Photo_editor pe = new Photo_editor();
            }
        });

        export.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                VideoWriter vidwriter = new VideoWriter(); //not working
            }
        });

        saveas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionevent) {
                Save_as save_as = new Save_as();
            }
        });

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Save_Algorithm sa = new Save_Algorithm();
                    sa.projectFile("Last Captured Picture", Controls.framename);
                    sa.projectFile("Number of Scenes", Save_Algorithm.scenenum);
                } catch (IOException ex) {
                    Logger.getLogger(Toolbar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                CanonCamera camera = new CanonCamera();
                camera.endLiveView();
                camera.closeSession();
                CanonCamera.close();
                try {
                    Frame.grabber.stop();
                } catch (Exception ex) {
                    Logger.getLogger(Toolbar.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            }
        });

        video.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    //need to build a video editor
                    runtime.exec("");
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        });
    }
}