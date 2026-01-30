import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class MainGUI extends JFrame {
    private KisiYonetimi kisiYonetimi;
    private DosyaYoneticisi dosyaYoneticisi;
    private String currentUserEmail;
    private Kisi currentUser;
    
    // Events
    private ArrayList<Konser> konserler;
    private ArrayList<Tiyatro> tiyatrolar;
    private ArrayList<Festival> festivaller;
    private ArrayList<StandUp> standUplar;
    
    // Modern color scheme
    private static final Color PRIMARY_COLOR = new Color(99, 102, 241); // Indigo
    private static final Color SECONDARY_COLOR = new Color(139, 92, 246); // Purple
    private static final Color SUCCESS_COLOR = new Color(34, 197, 94); // Green
    private static final Color DANGER_COLOR = new Color(239, 68, 68); // Red
    private static final Color WARNING_COLOR = new Color(251, 146, 60); // Orange
    private static final Color INFO_COLOR = new Color(59, 130, 246); // Blue
    private static final Color BG_COLOR = new Color(249, 250, 251); // Light gray
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Font HEADING_FONT = new Font("Segoe UI", Font.BOLD, 28);
    private static final Font SUBHEADING_FONT = new Font("Segoe UI", Font.BOLD, 18);
    private static final Font BODY_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    
    public MainGUI() {
        kisiYonetimi = new KisiYonetimi();
        dosyaYoneticisi = new DosyaYoneticisi();
        initializeEvents();
        
        setTitle("Ticket Sales System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setResizable(true);
        
        showLoginWindow();
    }
    
    private void initializeEvents() {
        konserler = new ArrayList<>();
        konserler.add(new Konser("Buray Konseri", "07 Şubat Çar - 21:00", "TED Ankara Koleji - Ata Sahne"));
        konserler.add(new Konser("Sıla Konseri", "09 Şubat Cum - 21:00", "TED Ankara Koleji - Ata Sahne"));
        konserler.add(new Konser("Erol Evgin Konseri", "01 Mart Cum - 21:00", "TED Ankara Koleji - Ata Sahne"));
        konserler.add(new Konser("Fatma Turgut Akustik Konseri", "08 Mart Cum / 20:00", "Yenimahalle Nazım Hikmet Kültür Merkezi"));
        konserler.add(new Konser("Evrencan Gündüz Konseri", "19 Ocak Cum - 21:00", "IF Performance Hall"));
        konserler.add(new Konser("CanOzan Konseri", "02 Şubat Cum - 20:00", "Yenimahalle Nazım Hikmet Kültür Merkezi"));
        konserler.add(new Konser("Ufuk Beydemir Konseri", "04 Şubat Paz - 22:00", "6:45 KK Tunus"));
        
        tiyatrolar = new ArrayList<>();
        tiyatrolar.add(new Tiyatro("Aydınlıkevler Tiyatrosu", "25 Ocak Per - 21:00", "Congresium Ankara"));
        tiyatrolar.add(new Tiyatro("Yeraltından Notlar Tiyatrosu", "08 Ocak - 20:00", "Ankara Yeni Sahne"));
        tiyatrolar.add(new Tiyatro("Richard Tiyatrosu", "27 Ocak Cmt - 20:00", "MEB Şura Salonu"));
        tiyatrolar.add(new Tiyatro("Çok Güzel Hareketler 2","18 Şubat Paz - 20:00","Yenimahalle Nazım Hikmet Kültür Merkezi-Genco Erkal Sahnesi"));
        tiyatrolar.add(new Tiyatro("Morgue Sokağı Cinayeti Tiyatrosu","23 Ocak Sal - 20:00","CerModern Etkinlikleri"));
        tiyatrolar.add(new Tiyatro("Notre Dame'ın Kamburu Müzikali","12 Şubat Pzt - 20:30","MEB Şura Salonu"));
        
        festivaller = new ArrayList<>();
        festivaller.add(new Festival("What A Fast","22 Ağustos - 25 Ağustos", "Foça Sahili - İzmir"));
        festivaller.add(new Festival("Kocaeli Müzik Festivali","10 Mayıs - 12 Mayıs", "Emex Otel - Kocaeli"));
        festivaller.add(new Festival("Sakarya Müzik Festivali","16 Mayıs - 18 Mayıs", "Del Lago Luxury Hotel - Sakarya"));
        festivaller.add(new Festival("Çanakkale Müzik Festivali","10 Mayıs - 12 Mayıs", "Sunsan Hotel - Çanakkale"));
        festivaller.add(new Festival("Bolu Müzik Festivali","11 Ekim - 13 Ekim", "VonResort Abant - Bolu"));
        festivaller.add(new Festival("Konya Müzik Festivali","24 Mayıs - 26 Mayıs", "Grand Hotel - Konya"));
        
        standUplar = new ArrayList<>();
        standUplar.add(new StandUp("Sergen Deveci Stand Up", "13 Ocak Cmt - 20:30", "Çankaya Sahne"));
        standUplar.add(new StandUp("Okan Cabalar Stand Up", "27 Ocak Cmt - 19:00", "Route Ankara Sahnesi"));
        standUplar.add(new StandUp("Doğu Demirkol Stand Up", "30 Ocak Salı - 20:30", "Yenimahalle Nazım Hikmet Kültür Merkezi"));
        standUplar.add(new StandUp("Mesut Süre 'Siz Hepiniz Ben Tek'", "06 Ocak Cmt - 20:30", "Çankaya Sahne"));
        standUplar.add(new StandUp("Berfu & Eser Yenenler - Çift Terapisi Stand Up", "31 Ocak Çar - 21:00", "MEB Şura Salonu"));
        standUplar.add(new StandUp("Aşkım Kapışmak ile İlişkiler Komedisi Stand Up", "17 Ocak Çar - 20:00", "MEB Şura Salonu"));
    }
    
    // Modern gradient panel
    private JPanel createGradientPanel(Color color1, Color color2) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
    }
    
    // Modern button with hover effect
    private JButton createModernButton(String text, Color bgColor, Color hoverColor, int width, int height) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                if (getModel().isPressed()) {
                    g2d.setColor(bgColor.darker());
                } else if (getModel().isRollover()) {
                    g2d.setColor(hoverColor);
                } else {
                    g2d.setColor(bgColor);
                }
                
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
                g2d.dispose();
                
                super.paintComponent(g);
            }
        };
        
        button.setFont(BODY_FONT.deriveFont(Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(width, height));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        
        return button;
    }
    
    // Modern text field
    private JTextField createModernTextField(int columns) {
        JTextField field = new JTextField(columns);
        field.setFont(BODY_FONT);
        field.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(229, 231, 235), 1),
            new EmptyBorder(10, 15, 10, 15)
        ));
        field.setBackground(CARD_COLOR);
        return field;
    }
    
    // Modern password field
    private JPasswordField createModernPasswordField(int columns) {
        JPasswordField field = new JPasswordField(columns);
        field.setFont(BODY_FONT);
        field.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(229, 231, 235), 1),
            new EmptyBorder(10, 15, 10, 15)
        ));
        field.setBackground(CARD_COLOR);
        return field;
    }
    
    public void showLoginWindow() {
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        
        // Main container with background
        JPanel mainContainer = new JPanel(new BorderLayout());
        mainContainer.setBackground(BG_COLOR);
        
        // Top gradient header
        JPanel topPanel = createGradientPanel(PRIMARY_COLOR, SECONDARY_COLOR);
        topPanel.setBorder(new EmptyBorder(40, 0, 40, 0));
        topPanel.setLayout(new BorderLayout());
        
        JLabel titleLabel = new JLabel("TICKET SALES SYSTEM", JLabel.CENTER);
        titleLabel.setFont(HEADING_FONT);
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        
        // Center panel with card
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(BG_COLOR);
        centerPanel.setBorder(new EmptyBorder(60, 40, 60, 40));
        
        // Card panel
        JPanel cardPanel = new JPanel(new GridBagLayout());
        cardPanel.setBackground(CARD_COLOR);
        cardPanel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(229, 231, 235), 1),
            new EmptyBorder(50, 60, 50, 60)
        ));
        
        // Add shadow effect
        cardPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 0, 0, 10), 1),
            new EmptyBorder(50, 60, 50, 60)
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Email
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel emailLabel = new JLabel("Email Address:");
        emailLabel.setFont(BODY_FONT.deriveFont(Font.BOLD));
        emailLabel.setForeground(new Color(55, 65, 81));
        cardPanel.add(emailLabel, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        JTextField emailField = createModernTextField(25);
        cardPanel.add(emailField, gbc);
        
        // Password
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(BODY_FONT.deriveFont(Font.BOLD));
        passwordLabel.setForeground(new Color(55, 65, 81));
        cardPanel.add(passwordLabel, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        JPasswordField passwordField = createModernPasswordField(25);
        cardPanel.add(passwordField, gbc);
        
        // Buttons
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setOpaque(false);
        
        JButton loginButton = createModernButton("Sign In", PRIMARY_COLOR, PRIMARY_COLOR.brighter(), 140, 45);
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            if (login(email, password)) {
                showMainMenu();
            }
        });
        
        JButton registerButton = createModernButton("Sign Up", SUCCESS_COLOR, SUCCESS_COLOR.brighter(), 140, 45);
        registerButton.addActionListener(e -> showRegisterWindow());
        
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        cardPanel.add(buttonPanel, gbc);
        
        centerPanel.add(cardPanel);
        
        mainContainer.add(topPanel, BorderLayout.NORTH);
        mainContainer.add(centerPanel, BorderLayout.CENTER);
        
        add(mainContainer);
        
        revalidate();
        repaint();
    }
    
    private void showRegisterWindow() {
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        
        JPanel mainContainer = new JPanel(new BorderLayout());
        mainContainer.setBackground(BG_COLOR);
        
        // Top gradient header
        JPanel topPanel = createGradientPanel(SUCCESS_COLOR, new Color(34, 197, 94).darker());
        topPanel.setBorder(new EmptyBorder(30, 0, 30, 0));
        topPanel.setLayout(new BorderLayout());
        
        JLabel titleLabel = new JLabel("CREATE NEW ACCOUNT", JLabel.CENTER);
        titleLabel.setFont(HEADING_FONT);
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        
        JButton backButton = createModernButton("← Back", new Color(255, 255, 255, 0), new Color(255, 255, 255, 30), 100, 35);
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        backButton.addActionListener(e -> showLoginWindow());
        topPanel.add(backButton, BorderLayout.WEST);
        
        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(BG_COLOR);
        formPanel.setBorder(new EmptyBorder(40, 40, 40, 40));
        
        // Card panel
        JPanel cardPanel = new JPanel(new GridBagLayout());
        cardPanel.setBackground(CARD_COLOR);
        cardPanel.setBorder(new EmptyBorder(50, 60, 50, 60));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Name
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel nameLabel = new JLabel("First Name:");
        nameLabel.setFont(BODY_FONT.deriveFont(Font.BOLD));
        nameLabel.setForeground(new Color(55, 65, 81));
        cardPanel.add(nameLabel, gbc);
        
        gbc.gridx = 1;
        JTextField nameField = createModernTextField(25);
        cardPanel.add(nameField, gbc);
        
        // Surname
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel surnameLabel = new JLabel("Last Name:");
        surnameLabel.setFont(BODY_FONT.deriveFont(Font.BOLD));
        surnameLabel.setForeground(new Color(55, 65, 81));
        cardPanel.add(surnameLabel, gbc);
        
        gbc.gridx = 1;
        JTextField surnameField = createModernTextField(25);
        cardPanel.add(surnameField, gbc);
        
        // Email
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel emailLabel = new JLabel("Email Address:");
        emailLabel.setFont(BODY_FONT.deriveFont(Font.BOLD));
        emailLabel.setForeground(new Color(55, 65, 81));
        cardPanel.add(emailLabel, gbc);
        
        gbc.gridx = 1;
        JTextField emailField = createModernTextField(25);
        cardPanel.add(emailField, gbc);
        
        // Password
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(BODY_FONT.deriveFont(Font.BOLD));
        passwordLabel.setForeground(new Color(55, 65, 81));
        cardPanel.add(passwordLabel, gbc);
        
        gbc.gridx = 1;
        JPasswordField passwordField = createModernPasswordField(25);
        cardPanel.add(passwordField, gbc);
        
        // Buttons
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setOpaque(false);
        
        JButton registerButton = createModernButton("Create Account", SUCCESS_COLOR, SUCCESS_COLOR.brighter(), 160, 45);
        registerButton.addActionListener(e -> {
            try {
                DosyaYoneticisi.dosyadanGelenVeriyiArrayListeKaydet();
                String name = nameField.getText();
                String surname = surnameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                
                if (!email.contains("@") || !email.contains(".com")) {
                    JOptionPane.showMessageDialog(this, "Email address must contain @ and .com", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                int dotIndex = email.indexOf(".com");
                if (dotIndex + 4 != email.length()) {
                    JOptionPane.showMessageDialog(this, "Please do not add text after .com", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                for (Kisi kisi : KisiYonetimi.getKullaniciListesi()) {
                    if (kisi.getKullaniciEMail().equals(email)) {
                        JOptionPane.showMessageDialog(this, "An account with this email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                
                Kisi yeniKisi = new Kisi(name, surname, email, password, "null");
                KisiYonetimi.getKullaniciListesi().add(yeniKisi);
                DosyaYoneticisi.kullaniciBilgileriniYazdir();
                
                JOptionPane.showMessageDialog(this, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                showLoginWindow();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JButton backBtn = createModernButton("Cancel", new Color(156, 163, 175), new Color(156, 163, 175).brighter(), 120, 45);
        backBtn.addActionListener(e -> showLoginWindow());
        
        buttonPanel.add(registerButton);
        buttonPanel.add(backBtn);
        cardPanel.add(buttonPanel, gbc);
        
        formPanel.add(cardPanel);
        
        mainContainer.add(topPanel, BorderLayout.NORTH);
        mainContainer.add(formPanel, BorderLayout.CENTER);
        
        add(mainContainer);
        
        revalidate();
        repaint();
    }
    
    private boolean login(String email, String password) {
        try {
            DosyaYoneticisi.dosyadanGelenVeriyiArrayListeKaydet();
            for (Kisi kisi : KisiYonetimi.getKullaniciListesi()) {
                if (kisi.getKullaniciEMail().equals(email) && kisi.getKullaniciSifre().equals(password)) {
                    currentUserEmail = email;
                    currentUser = kisi;
                    KisiYonetimi.seteMailTut(email);
                    return true;
                }
            }
            JOptionPane.showMessageDialog(this, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Login error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public void showMainMenu() {
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        
        JPanel mainContainer = new JPanel(new BorderLayout());
        mainContainer.setBackground(BG_COLOR);
        
        // Top header
        JPanel topPanel = createGradientPanel(PRIMARY_COLOR, SECONDARY_COLOR);
        topPanel.setBorder(new EmptyBorder(25, 30, 25, 30));
        topPanel.setLayout(new BorderLayout());
        
        JLabel welcomeLabel = new JLabel("Welcome, " + currentUser.getKullaniciAdi().toUpperCase(), JLabel.CENTER);
        welcomeLabel.setFont(SUBHEADING_FONT);
        welcomeLabel.setForeground(Color.WHITE);
        topPanel.add(welcomeLabel, BorderLayout.CENTER);
        
        JButton logoutButton = createModernButton("Logout", DANGER_COLOR, DANGER_COLOR.brighter(), 100, 35);
        logoutButton.addActionListener(e -> {
            currentUser = null;
            currentUserEmail = null;
            showLoginWindow();
        });
        topPanel.add(logoutButton, BorderLayout.EAST);
        
        // Menu grid
        JPanel menuPanel = new JPanel(new GridLayout(3, 2, 25, 25));
        menuPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        menuPanel.setBackground(BG_COLOR);
        
        JButton konserButton = createMenuCard("CONCERTS", "🎵", PRIMARY_COLOR);
        konserButton.addActionListener(e -> showEventList("Konser"));
        
        JButton tiyatroButton = createMenuCard("THEATER", "🎭", SECONDARY_COLOR);
        tiyatroButton.addActionListener(e -> showEventList("Tiyatro"));
        
        JButton festivalButton = createMenuCard("FESTIVALS", "🎪", WARNING_COLOR);
        festivalButton.addActionListener(e -> showEventList("Festival"));
        
        JButton standUpButton = createMenuCard("STAND UP", "🎤", INFO_COLOR);
        standUpButton.addActionListener(e -> showEventList("StandUp"));
        
        JButton hesabimButton = createMenuCard("MY ACCOUNT", "👤", SUCCESS_COLOR);
        hesabimButton.addActionListener(e -> showAccountWindow());
        
        JButton biletlerimButton = createMenuCard("MY TICKETS", "🎫", new Color(168, 85, 247));
        biletlerimButton.addActionListener(e -> showMyTickets());
        
        menuPanel.add(konserButton);
        menuPanel.add(tiyatroButton);
        menuPanel.add(festivalButton);
        menuPanel.add(standUpButton);
        menuPanel.add(hesabimButton);
        menuPanel.add(biletlerimButton);
        
        mainContainer.add(topPanel, BorderLayout.NORTH);
        mainContainer.add(menuPanel, BorderLayout.CENTER);
        
        add(mainContainer);
        
        revalidate();
        repaint();
    }
    
    private JButton createMenuCard(String text, String icon, Color color) {
        JButton button = new JButton("<html><center><div style='font-size:48px; margin-bottom:10px;'>" + icon + "</div><div style='font-size:18px; font-weight:bold;'>" + text + "</div></center></html>") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                if (getModel().isPressed()) {
                    g2d.setColor(color.darker());
                } else if (getModel().isRollover()) {
                    g2d.setColor(color.brighter());
                } else {
                    g2d.setColor(color);
                }
                
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                
                // Shadow
                g2d.setColor(new Color(0, 0, 0, 20));
                g2d.fillRoundRect(2, 2, getWidth(), getHeight(), 20, 20);
                g2d.dispose();
                
                super.paintComponent(g);
            }
        };
        
        button.setFont(BODY_FONT);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(300, 180));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        
        return button;
    }
    
    private void showEventList(String eventType) {
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        
        JPanel mainContainer = new JPanel(new BorderLayout());
        mainContainer.setBackground(BG_COLOR);
        
        // Top header
        JPanel topPanel = createGradientPanel(PRIMARY_COLOR, SECONDARY_COLOR);
        topPanel.setBorder(new EmptyBorder(20, 30, 20, 30));
        topPanel.setLayout(new BorderLayout());
        
        String titleText = eventType.toUpperCase() + " EVENTS";
        JLabel titleLabel = new JLabel(titleText, JLabel.CENTER);
        titleLabel.setFont(SUBHEADING_FONT);
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        
        JButton backButton = createModernButton("← Back", new Color(255, 255, 255, 0), new Color(255, 255, 255, 30), 100, 35);
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        backButton.addActionListener(e -> showMainMenu());
        topPanel.add(backButton, BorderLayout.WEST);
        
        // Event list
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBorder(new EmptyBorder(30, 40, 30, 40));
        listPanel.setBackground(BG_COLOR);
        
        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(BG_COLOR);
        
        ArrayList<? extends Etkinlik> events = null;
        if (eventType.equals("Konser")) {
            events = konserler;
        } else if (eventType.equals("Tiyatro")) {
            events = tiyatrolar;
        } else if (eventType.equals("Festival")) {
            events = festivaller;
        } else if (eventType.equals("StandUp")) {
            events = standUplar;
        }
        
        if (events != null) {
            for (int i = 0; i < events.size(); i++) {
                Etkinlik event = events.get(i);
                JPanel eventPanel = createEventCard(event, i, eventType);
                listPanel.add(eventPanel);
                listPanel.add(Box.createVerticalStrut(15));
            }
        }
        
        mainContainer.add(topPanel, BorderLayout.NORTH);
        mainContainer.add(scrollPane, BorderLayout.CENTER);
        
        add(mainContainer);
        
        revalidate();
        repaint();
    }
    
    private JPanel createEventCard(Etkinlik event, int index, String eventType) {
        JPanel panel = new JPanel(new BorderLayout(20, 10));
        panel.setBackground(CARD_COLOR);
        panel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(229, 231, 235), 1),
            new EmptyBorder(20, 25, 20, 25)
        ));
        
        JLabel nameLabel = new JLabel(event.getAd());
        nameLabel.setFont(BODY_FONT.deriveFont(Font.BOLD, 18));
        nameLabel.setForeground(new Color(17, 24, 39));
        
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
        infoPanel.setOpaque(false);
        JLabel dateLabel = new JLabel("📅 " + event.getTarih());
        dateLabel.setFont(BODY_FONT);
        dateLabel.setForeground(new Color(107, 114, 128));
        JLabel locationLabel = new JLabel("📍 " + event.getKonum());
        locationLabel.setFont(BODY_FONT);
        locationLabel.setForeground(new Color(107, 114, 128));
        infoPanel.add(dateLabel);
        infoPanel.add(locationLabel);
        
        JButton detailButton = createModernButton("View Details", PRIMARY_COLOR, PRIMARY_COLOR.brighter(), 130, 40);
        detailButton.addActionListener(e -> showEventDetail(event, index, eventType));
        
        panel.add(nameLabel, BorderLayout.NORTH);
        panel.add(infoPanel, BorderLayout.CENTER);
        panel.add(detailButton, BorderLayout.EAST);
        
        return panel;
    }
    
    private void showEventDetail(Etkinlik event, int index, String eventType) {
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        
        JPanel mainContainer = new JPanel(new BorderLayout());
        mainContainer.setBackground(BG_COLOR);
        
        // Top header
        JPanel topPanel = createGradientPanel(PRIMARY_COLOR, SECONDARY_COLOR);
        topPanel.setBorder(new EmptyBorder(20, 30, 20, 30));
        topPanel.setLayout(new BorderLayout());
        
        JLabel titleLabel = new JLabel(event.getAd(), JLabel.CENTER);
        titleLabel.setFont(SUBHEADING_FONT);
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        
        JButton backButton = createModernButton("← Back", new Color(255, 255, 255, 0), new Color(255, 255, 255, 30), 100, 35);
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        backButton.addActionListener(e -> showEventList(eventType));
        topPanel.add(backButton, BorderLayout.WEST);
        
        // Detail panel
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));
        detailPanel.setBorder(new EmptyBorder(50, 80, 50, 80));
        detailPanel.setBackground(BG_COLOR);
        
        // Info card
        JPanel infoCard = new JPanel(new GridBagLayout());
        infoCard.setBackground(CARD_COLOR);
        infoCard.setBorder(new EmptyBorder(30, 40, 30, 40));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel dateLabel = new JLabel("📅 Date: " + event.getTarih());
        dateLabel.setFont(BODY_FONT.deriveFont(Font.BOLD, 16));
        dateLabel.setForeground(new Color(55, 65, 81));
        infoCard.add(dateLabel, gbc);
        
        gbc.gridy = 1;
        JLabel locationLabel = new JLabel("📍 Location: " + event.getKonum());
        locationLabel.setFont(BODY_FONT.deriveFont(Font.BOLD, 16));
        locationLabel.setForeground(new Color(55, 65, 81));
        infoCard.add(locationLabel, gbc);
        
        detailPanel.add(infoCard);
        detailPanel.add(Box.createVerticalStrut(30));
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        buttonPanel.setOpaque(false);
        
        JButton infoButton = createModernButton("Event Info", INFO_COLOR, INFO_COLOR.brighter(), 140, 45);
        infoButton.addActionListener(e -> {
            try {
                int startLine = getStartLine(eventType, index);
                int endLine = getEndLine(eventType, index);
                showEventInfo(event, startLine, endLine);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Could not read information: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JButton rulesButton = createModernButton("Event Rules", WARNING_COLOR, WARNING_COLOR.brighter(), 140, 45);
        rulesButton.addActionListener(e -> {
            try {
                showEventRules(event);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Could not read rules: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JButton buyTicketButton = createModernButton("Buy Ticket", SUCCESS_COLOR, SUCCESS_COLOR.brighter(), 160, 50);
        buyTicketButton.setFont(BODY_FONT.deriveFont(Font.BOLD, 16));
        buyTicketButton.addActionListener(e -> {
            try {
                showBuyTicketWindow(event, index, eventType);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Ticket purchase error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        buttonPanel.add(infoButton);
        buttonPanel.add(rulesButton);
        buttonPanel.add(buyTicketButton);
        
        detailPanel.add(buttonPanel);
        
        mainContainer.add(topPanel, BorderLayout.NORTH);
        mainContainer.add(detailPanel, BorderLayout.CENTER);
        
        add(mainContainer);
        
        revalidate();
        repaint();
    }
    
    private int getStartLine(String eventType, int index) {
        return 1;
    }
    
    private int getEndLine(String eventType, int index) {
        return 10;
    }
    
    private void showEventInfo(Etkinlik event, int startLine, int endLine) throws IOException {
        JDialog dialog = new JDialog(this, "Event Information", true);
        dialog.setSize(700, 500);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout());
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(BODY_FONT);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBackground(CARD_COLOR);
        textArea.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("etkinlikHakkinda.txt"));
            String line;
            int lineNum = 0;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                lineNum++;
                if (lineNum >= startLine && lineNum <= endLine) {
                    content.append(line).append("\n");
                }
                if (lineNum > endLine) break;
            }
            reader.close();
            textArea.setText(content.toString());
        } catch (IOException e) {
            textArea.setText("Information not found.");
        }
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(null);
        dialog.add(scrollPane, BorderLayout.CENTER);
        dialog.setVisible(true);
    }
    
    private void showEventRules(Etkinlik event) throws IOException {
        JDialog dialog = new JDialog(this, "Event Rules", true);
        dialog.setSize(700, 500);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout());
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(BODY_FONT);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBackground(CARD_COLOR);
        textArea.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("etkinlikKurallari.txt"));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
            textArea.setText(content.toString());
        } catch (IOException e) {
            textArea.setText("Rules not found.");
        }
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(null);
        dialog.add(scrollPane, BorderLayout.CENTER);
        dialog.setVisible(true);
    }
    
    private void showBuyTicketWindow(Etkinlik event, int index, String eventType) throws IOException {
        String[] ticketOptions = {"(1) VIP Ticket", "(2) Regular Ticket", "(3) Student Ticket"};
        int ticketChoice = JOptionPane.showOptionDialog(this,
            "Select ticket type:",
            "Ticket Selection",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            ticketOptions,
            ticketOptions[0]);
        
        if (ticketChoice == JOptionPane.CLOSED_OPTION) {
            return;
        }
        
        int ticketNumber = ticketChoice + 1;
        
        String price = getTicketPrice(event, ticketNumber, eventType, index);
        if (price == null || price.isEmpty()) {
            price = "Price information not available";
        }
        
        int confirm = JOptionPane.showConfirmDialog(this,
            "Ticket Price: " + price + "\n\nDo you want to purchase this ticket?",
            "Purchase Ticket",
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            processPayment(event, ticketNumber, eventType, index);
        }
    }
    
    private String getTicketPrice(Etkinlik event, int ticketNumber, String eventType, int index) {
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("etkinlikHakkinda.txt"));
            String line;
            int lineNum = 0;
            int startLine = getStartLine(eventType, index);
            int endLine = getEndLine(eventType, index);
            
            while ((line = reader.readLine()) != null) {
                lineNum++;
                if (lineNum >= startLine && lineNum <= endLine) {
                    if (line.contains("(" + ticketNumber + ")")) {
                        String price = line.substring(Math.max(0, line.length() - 10));
                        reader.close();
                        return price.trim();
                    }
                }
                if (lineNum > endLine) break;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private void processPayment(Etkinlik event, int ticketNumber, String eventType, int index) {
        DosyaYoneticisi.dosyadanGelenVeriyiArrayListeKaydet();
        
        Kisi user = null;
        for (Kisi kisi : KisiYonetimi.getKullaniciListesi()) {
            if (kisi.getKullaniciEMail().equals(currentUserEmail)) {
                user = kisi;
                break;
            }
        }
        
        if (user == null) {
            JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (user.getKrediKarti() == null || user.getKrediKarti().equals("null")) {
            showAddCreditCardDialog(user, event, ticketNumber, eventType, index);
        } else {
            int useCard = JOptionPane.showConfirmDialog(this,
                "Registered credit card: " + maskCard(user.getKrediKarti()) + "\n\nDo you want to continue with this card?",
                "Payment",
                JOptionPane.YES_NO_OPTION);
            
            if (useCard == JOptionPane.YES_OPTION) {
                completePurchase(event, ticketNumber, eventType, index);
            } else {
                showAddCreditCardDialog(user, event, ticketNumber, eventType, index);
            }
        }
    }
    
    private String maskCard(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) return "****";
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }
    
    private void showAddCreditCardDialog(Kisi user, Etkinlik event, int ticketNumber, String eventType, int index) {
        JDialog cardDialog = new JDialog(this, "Credit Card Information", true);
        cardDialog.setSize(500, 400);
        cardDialog.setLocationRelativeTo(this);
        cardDialog.setLayout(new BorderLayout());
        cardDialog.getContentPane().setBackground(BG_COLOR);
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(CARD_COLOR);
        formPanel.setBorder(new EmptyBorder(40, 40, 40, 40));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel cardLabel = new JLabel("Card Number (16 digits):");
        cardLabel.setFont(BODY_FONT.deriveFont(Font.BOLD));
        formPanel.add(cardLabel, gbc);
        gbc.gridx = 1;
        JTextField cardField = createModernTextField(20);
        formPanel.add(cardField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel cvvLabel = new JLabel("CVV (3 digits):");
        cvvLabel.setFont(BODY_FONT.deriveFont(Font.BOLD));
        formPanel.add(cvvLabel, gbc);
        gbc.gridx = 1;
        JTextField cvvField = createModernTextField(5);
        formPanel.add(cvvField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel monthLabel = new JLabel("Month (MM):");
        monthLabel.setFont(BODY_FONT.deriveFont(Font.BOLD));
        formPanel.add(monthLabel, gbc);
        gbc.gridx = 1;
        JTextField monthField = createModernTextField(5);
        formPanel.add(monthField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel yearLabel = new JLabel("Year (YYYY):");
        yearLabel.setFont(BODY_FONT.deriveFont(Font.BOLD));
        formPanel.add(yearLabel, gbc);
        gbc.gridx = 1;
        JTextField yearField = createModernTextField(5);
        formPanel.add(yearField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setOpaque(false);
        
        JButton saveButton = createModernButton(event != null ? "Save & Continue" : "Save", SUCCESS_COLOR, SUCCESS_COLOR.brighter(), 150, 45);
        saveButton.addActionListener(e -> {
            String card = cardField.getText();
            String cvv = cvvField.getText();
            String month = monthField.getText();
            String year = yearField.getText();
            
            if (card.length() == 16 && cvv.length() == 3 && month.length() == 2 && year.length() == 4) {
                user.setKrediKarti(card);
                DosyaYoneticisi.kullaniciBilgileriniYazdir();
                cardDialog.dispose();
                if (event != null) {
                    completePurchase(event, ticketNumber, eventType, index);
                } else {
                    showAccountWindow();
                }
            } else {
                JOptionPane.showMessageDialog(cardDialog, "Please check your information!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JButton cancelButton = createModernButton("Cancel", new Color(156, 163, 175), new Color(156, 163, 175).brighter(), 120, 45);
        cancelButton.addActionListener(e -> cardDialog.dispose());
        
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        formPanel.add(buttonPanel, gbc);
        
        cardDialog.add(formPanel, BorderLayout.CENTER);
        cardDialog.setVisible(true);
    }
    
    private void completePurchase(Etkinlik event, int ticketNumber, String eventType, int index) {
        String price = getTicketPrice(event, ticketNumber, eventType, index);
        if (price == null) price = "";
        
        try {
            java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter("bilettakip.txt", true));
            writer.write(currentUserEmail + " " + event.getAd() + " " + price);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String ticketInfo = "===========================\n" +
                           "TICKET\n" +
                           "===========================\n" +
                           event.getAd() + "\n" +
                           currentUser.getKullaniciAdi() + " " + currentUser.getKullaniciSoyIsim() + "\n\n" +
                           event.getTarih() + "\n" +
                           event.getKonum() + "\n" +
                           "Price: " + price + "\n" +
                           "===========================";
        
        JOptionPane.showMessageDialog(this, ticketInfo, "Purchase Successful!", JOptionPane.INFORMATION_MESSAGE);
        
        int choice = JOptionPane.showOptionDialog(this,
            "What would you like to do?",
            "Selection",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[]{"Main Menu", "Event List"},
            "Main Menu");
        
        if (choice == 0) {
            showMainMenu();
        } else {
            showEventList(eventType);
        }
    }
    
    private void showAccountWindow() {
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        
        JPanel mainContainer = new JPanel(new BorderLayout());
        mainContainer.setBackground(BG_COLOR);
        
        // Top header
        JPanel topPanel = createGradientPanel(SUCCESS_COLOR, new Color(34, 197, 94).darker());
        topPanel.setBorder(new EmptyBorder(20, 30, 20, 30));
        topPanel.setLayout(new BorderLayout());
        
        JLabel titleLabel = new JLabel("MY ACCOUNT", JLabel.CENTER);
        titleLabel.setFont(SUBHEADING_FONT);
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        
        JButton backButton = createModernButton("← Back", new Color(255, 255, 255, 0), new Color(255, 255, 255, 30), 100, 35);
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        backButton.addActionListener(e -> showMainMenu());
        topPanel.add(backButton, BorderLayout.WEST);
        
        // Account info panel
        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(new BoxLayout(accountPanel, BoxLayout.Y_AXIS));
        accountPanel.setBorder(new EmptyBorder(50, 80, 50, 80));
        accountPanel.setBackground(BG_COLOR);
        
        DosyaYoneticisi.dosyadanGelenVeriyiArrayListeKaydet();
        final Kisi[] userRef = new Kisi[1];
        for (Kisi kisi : KisiYonetimi.getKullaniciListesi()) {
            if (kisi.getKullaniciEMail().equals(currentUserEmail)) {
                userRef[0] = kisi;
                break;
            }
        }
        
        if (userRef[0] != null) {
            final Kisi user = userRef[0];
            
            // Account card
            JPanel accountCard = new JPanel(new GridBagLayout());
            accountCard.setBackground(CARD_COLOR);
            accountCard.setBorder(new EmptyBorder(40, 50, 40, 50));
            
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(15, 15, 15, 15);
            gbc.anchor = GridBagConstraints.WEST;
            
            gbc.gridx = 0; gbc.gridy = 0;
            JLabel nameLabel = new JLabel("First Name: " + user.getKullaniciAdi());
            nameLabel.setFont(BODY_FONT.deriveFont(Font.BOLD, 16));
            nameLabel.setForeground(new Color(55, 65, 81));
            accountCard.add(nameLabel, gbc);
            
            gbc.gridy = 1;
            JLabel surnameLabel = new JLabel("Last Name: " + user.getKullaniciSoyIsim());
            surnameLabel.setFont(BODY_FONT.deriveFont(Font.BOLD, 16));
            surnameLabel.setForeground(new Color(55, 65, 81));
            accountCard.add(surnameLabel, gbc);
            
            gbc.gridy = 2;
            JLabel emailLabel = new JLabel("Email: " + user.getKullaniciEMail());
            emailLabel.setFont(BODY_FONT.deriveFont(Font.BOLD, 16));
            emailLabel.setForeground(new Color(55, 65, 81));
            accountCard.add(emailLabel, gbc);
            
            gbc.gridy = 3;
            String cardInfo = (user.getKrediKarti() != null && !user.getKrediKarti().equals("null")) 
                ? maskCard(user.getKrediKarti()) : "No card registered";
            JLabel cardLabel = new JLabel("Credit Card: " + cardInfo);
            cardLabel.setFont(BODY_FONT.deriveFont(Font.BOLD, 16));
            cardLabel.setForeground(new Color(55, 65, 81));
            accountCard.add(cardLabel, gbc);
            
            accountPanel.add(accountCard);
            accountPanel.add(Box.createVerticalStrut(30));
            
            // Buttons
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
            buttonPanel.setOpaque(false);
            
            JButton changePasswordButton = createModernButton("Change Password", INFO_COLOR, INFO_COLOR.brighter(), 160, 45);
            changePasswordButton.addActionListener(e -> showChangePasswordDialog(user));
            
            JButton manageCardButton = createModernButton("Manage Card", WARNING_COLOR, WARNING_COLOR.brighter(), 160, 45);
            manageCardButton.addActionListener(e -> showManageCardDialog(user));
            
            buttonPanel.add(changePasswordButton);
            buttonPanel.add(manageCardButton);
            accountPanel.add(buttonPanel);
        }
        
        mainContainer.add(topPanel, BorderLayout.NORTH);
        mainContainer.add(accountPanel, BorderLayout.CENTER);
        
        add(mainContainer);
        
        revalidate();
        repaint();
    }
    
    private void showChangePasswordDialog(Kisi user) {
        JDialog dialog = new JDialog(this, "Change Password", true);
        dialog.setSize(500, 350);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout());
        dialog.getContentPane().setBackground(BG_COLOR);
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(CARD_COLOR);
        formPanel.setBorder(new EmptyBorder(40, 40, 40, 40));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0;
        dialog.add(new JLabel("Old Password:"), gbc);
        gbc.gridx = 1;
        JPasswordField oldPasswordField = createModernPasswordField(18);
        formPanel.add(oldPasswordField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("New Password:"), gbc);
        gbc.gridx = 1;
        JPasswordField newPasswordField = createModernPasswordField(18);
        formPanel.add(newPasswordField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Confirm Password:"), gbc);
        gbc.gridx = 1;
        JPasswordField confirmPasswordField = createModernPasswordField(18);
        formPanel.add(confirmPasswordField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setOpaque(false);
        
        JButton saveButton = createModernButton("Save", SUCCESS_COLOR, SUCCESS_COLOR.brighter(), 120, 40);
        saveButton.addActionListener(e -> {
            String oldPass = new String(oldPasswordField.getPassword());
            String newPass = new String(newPasswordField.getPassword());
            String confirmPass = new String(confirmPasswordField.getPassword());
            
            if (!oldPass.equals(user.getKullaniciSifre())) {
                JOptionPane.showMessageDialog(dialog, "Old password is incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!newPass.equals(confirmPass)) {
                JOptionPane.showMessageDialog(dialog, "New passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            user.setKullaniciSifre(newPass);
            DosyaYoneticisi.kullaniciBilgileriniYazdir();
            JOptionPane.showMessageDialog(dialog, "Password changed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        });
        
        JButton cancelButton = createModernButton("Cancel", new Color(156, 163, 175), new Color(156, 163, 175).brighter(), 120, 40);
        cancelButton.addActionListener(e -> dialog.dispose());
        
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        formPanel.add(buttonPanel, gbc);
        
        dialog.add(formPanel, BorderLayout.CENTER);
        dialog.setVisible(true);
    }
    
    private void showManageCardDialog(Kisi user) {
        JDialog dialog = new JDialog(this, "Credit Card Management", true);
        dialog.setSize(500, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout());
        dialog.getContentPane().setBackground(BG_COLOR);
        
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(CARD_COLOR);
        contentPanel.setBorder(new EmptyBorder(40, 40, 40, 40));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        
        if (user.getKrediKarti() != null && !user.getKrediKarti().equals("null")) {
            gbc.gridx = 0; gbc.gridy = 0;
            gbc.gridwidth = 2;
            JLabel cardLabel = new JLabel("Registered Card: " + maskCard(user.getKrediKarti()));
            cardLabel.setFont(BODY_FONT.deriveFont(Font.BOLD, 16));
            contentPanel.add(cardLabel, gbc);
            
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
            buttonPanel.setOpaque(false);
            
            JButton deleteButton = createModernButton("Delete Card", DANGER_COLOR, DANGER_COLOR.brighter(), 140, 40);
            deleteButton.addActionListener(e -> {
                int confirm = JOptionPane.showConfirmDialog(dialog, "Are you sure you want to delete this card?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    user.setKrediKarti("null");
                    DosyaYoneticisi.kullaniciBilgileriniYazdir();
                    JOptionPane.showMessageDialog(dialog, "Card deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                    showAccountWindow();
                }
            });
            
            JButton addNewButton = createModernButton("Add New Card", SUCCESS_COLOR, SUCCESS_COLOR.brighter(), 140, 40);
            addNewButton.addActionListener(e -> {
                dialog.dispose();
                showAddCreditCardDialog(user, null, 0, "", 0);
            });
            
            buttonPanel.add(deleteButton);
            buttonPanel.add(addNewButton);
            contentPanel.add(buttonPanel, gbc);
        } else {
            gbc.gridx = 0; gbc.gridy = 0;
            gbc.gridwidth = 2;
            JLabel noCardLabel = new JLabel("No credit card registered.");
            noCardLabel.setFont(BODY_FONT.deriveFont(Font.BOLD, 16));
            contentPanel.add(noCardLabel, gbc);
            
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            JButton addButton = createModernButton("Add Card", SUCCESS_COLOR, SUCCESS_COLOR.brighter(), 140, 40);
            addButton.addActionListener(e -> {
                dialog.dispose();
                showAddCreditCardDialog(user, null, 0, "", 0);
            });
            contentPanel.add(addButton, gbc);
        }
        
        dialog.add(contentPanel, BorderLayout.CENTER);
        dialog.setVisible(true);
    }
    
    private void showMyTickets() {
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        
        JPanel mainContainer = new JPanel(new BorderLayout());
        mainContainer.setBackground(BG_COLOR);
        
        // Top header
        JPanel topPanel = createGradientPanel(WARNING_COLOR, new Color(251, 146, 60).darker());
        topPanel.setBorder(new EmptyBorder(20, 30, 20, 30));
        topPanel.setLayout(new BorderLayout());
        
        JLabel titleLabel = new JLabel("MY TICKETS", JLabel.CENTER);
        titleLabel.setFont(SUBHEADING_FONT);
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        
        JButton backButton = createModernButton("← Back", new Color(255, 255, 255, 0), new Color(255, 255, 255, 30), 100, 35);
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        backButton.addActionListener(e -> showMainMenu());
        topPanel.add(backButton, BorderLayout.WEST);
        
        // Ticket list
        JPanel ticketPanel = new JPanel();
        ticketPanel.setLayout(new BoxLayout(ticketPanel, BoxLayout.Y_AXIS));
        ticketPanel.setBorder(new EmptyBorder(30, 40, 30, 40));
        ticketPanel.setBackground(BG_COLOR);
        
        JScrollPane scrollPane = new JScrollPane(ticketPanel);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(BG_COLOR);
        
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("bilettakip.txt"));
            String line;
            boolean found = false;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+", 2);
                if (parts.length > 0 && parts[0].equals(currentUserEmail)) {
                    found = true;
                    JPanel ticketCard = new JPanel(new BorderLayout());
                    ticketCard.setBackground(CARD_COLOR);
                    ticketCard.setBorder(new EmptyBorder(20, 25, 20, 25));
                    
                    if (parts.length > 1) {
                        JLabel ticketLabel = new JLabel(parts[1]);
                        ticketLabel.setFont(BODY_FONT.deriveFont(Font.BOLD, 15));
                        ticketLabel.setForeground(new Color(55, 65, 81));
                        ticketCard.add(ticketLabel, BorderLayout.CENTER);
                    }
                    
                    ticketPanel.add(ticketCard);
                    ticketPanel.add(Box.createVerticalStrut(15));
                }
            }
            reader.close();
            
            if (!found) {
                JLabel noTicketLabel = new JLabel("No tickets found.");
                noTicketLabel.setFont(BODY_FONT.deriveFont(Font.BOLD, 16));
                noTicketLabel.setForeground(new Color(107, 114, 128));
                noTicketLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                ticketPanel.add(Box.createVerticalStrut(100));
                ticketPanel.add(noTicketLabel);
            }
        } catch (IOException e) {
            JLabel errorLabel = new JLabel("Error loading tickets: " + e.getMessage());
            errorLabel.setFont(BODY_FONT);
            errorLabel.setForeground(DANGER_COLOR);
            ticketPanel.add(errorLabel);
        }
        
        mainContainer.add(topPanel, BorderLayout.NORTH);
        mainContainer.add(scrollPane, BorderLayout.CENTER);
        
        add(mainContainer);
        
        revalidate();
        repaint();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new MainGUI().setVisible(true);
        });
    }
}
