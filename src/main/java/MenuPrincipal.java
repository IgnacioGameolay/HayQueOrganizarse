
import java.awt.CardLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JPanel{
    
    private CardLayout cardLayout;
    private GestorDeDatos gestorDeDatos;
    // Obtener la instancia de la agenda
    Agenda agenda = Agenda.getInstancia(); 
    

    public MenuPrincipal(GestorDeDatos gestorDeDatos) throws GUIException{
        this.gestorDeDatos = gestorDeDatos;
        initComponents();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        PanelCambiante = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        PanelAgregarEventosSimples = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jSpinField1 = new com.toedter.components.JSpinField();
        jSpinField2 = new com.toedter.components.JSpinField();
        jLabel7 = new javax.swing.JLabel();
        jSpinField3 = new com.toedter.components.JSpinField();
        jSpinField4 = new com.toedter.components.JSpinField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        PanelAgregarEventosRepetitivos = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jSpinField5 = new com.toedter.components.JSpinField();
        jSpinField6 = new com.toedter.components.JSpinField();
        jLabel14 = new javax.swing.JLabel();
        jSpinField7 = new com.toedter.components.JSpinField();
        jSpinField8 = new com.toedter.components.JSpinField();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        PanelMostrarEventos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PanelGenerarReporte = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        PanelBuscarEventosPorMes = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        PanelBuscarEventosPorDia = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jButton9 = new javax.swing.JButton();
        PanelEliminarEventosPorID = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jDateChooser11 = new com.toedter.calendar.JDateChooser();
        jDateChooser12 = new com.toedter.calendar.JDateChooser();
        jLabel41 = new javax.swing.JLabel();
        jSpinField18 = new com.toedter.components.JSpinField();
        jButton22 = new javax.swing.JButton();
        PanelBuscarEventosPorSemana = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jButton13 = new javax.swing.JButton();
        PanelBuscarEventosPorTramos = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jButton15 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        PanelBuscarEventosPorEtiquetas = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        PanelEditarEventoPorID = new javax.swing.JPanel();
        jTextField9 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jDateChooser9 = new com.toedter.calendar.JDateChooser();
        jDateChooser10 = new com.toedter.calendar.JDateChooser();
        jSpinField9 = new com.toedter.components.JSpinField();
        jSpinField10 = new com.toedter.components.JSpinField();
        jLabel31 = new javax.swing.JLabel();
        jSpinField11 = new com.toedter.components.JSpinField();
        jSpinField12 = new com.toedter.components.JSpinField();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jSpinField13 = new com.toedter.components.JSpinField();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();

        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("AGENDA DE EVENTOS");

        jButton1.setForeground(new java.awt.Color(0, 204, 153));
        jButton1.setText("Agregar Evento Simple");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(0, 204, 153));
        jButton2.setText("Mostrar Eventos");
        jButton2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jButton2StateChanged(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setForeground(new java.awt.Color(0, 204, 153));
        jButton3.setText("Buscar Eventos Por Dia");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setForeground(new java.awt.Color(0, 204, 153));
        jButton5.setText("Agregar Evento Repetitivo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setForeground(new java.awt.Color(0, 204, 153));
        jButton7.setText("Generar Reporte");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        PanelCambiante.setBackground(new java.awt.Color(153, 153, 153));
        PanelCambiante.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1051, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        PanelCambiante.add(jPanel1, "card4");

        PanelAgregarEventosSimples.setBackground(new java.awt.Color(102, 255, 255));
        PanelAgregarEventosSimples.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelAgregarEventosSimples.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField1.setText("Nombre Evento");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Ingese Nombre del Evento:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Ingese Descripción del Evento:");

        jTextField2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField2.setText("Lugar Evento");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Ingese Lugar del Evento:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Ingese Fecha y Hora de Inicio:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Ingese Fecha y Hora de Fin:");

        jButton4.setBackground(new java.awt.Color(255, 255, 0));
        jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton4.setText("Agregar Evento");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText(":");

        jLabel8.setText(":");

        jTextField8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField8.setText("Etiqueta");
        jTextField8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField8FocusLost(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setText("Ingese Etiqueta del Evento:");

        javax.swing.GroupLayout PanelAgregarEventosSimplesLayout = new javax.swing.GroupLayout(PanelAgregarEventosSimples);
        PanelAgregarEventosSimples.setLayout(PanelAgregarEventosSimplesLayout);
        PanelAgregarEventosSimplesLayout.setHorizontalGroup(
            PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jButton4)
                        .addGap(314, 314, 314))
                    .addGroup(PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                            .addGroup(PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 610, Short.MAX_VALUE))
                        .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                            .addGroup(PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(jSpinField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSpinField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(jSpinField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSpinField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(104, 104, 104)))))
        );
        PanelAgregarEventosSimplesLayout.setVerticalGroup(
            PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                .addGroup(PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAgregarEventosSimplesLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                        .addGroup(PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(71, 71, 71)
                        .addGroup(PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(PanelAgregarEventosSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(36, 36, 36)
                        .addComponent(jButton4)
                        .addGap(244, 244, 244))
                    .addGroup(PanelAgregarEventosSimplesLayout.createSequentialGroup()
                        .addComponent(jSpinField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        PanelCambiante.add(PanelAgregarEventosSimples, "cardAgregarEventosSimples");

        PanelAgregarEventosRepetitivos.setBackground(new java.awt.Color(102, 255, 255));
        PanelAgregarEventosRepetitivos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelAgregarEventosRepetitivos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField3.setText("Nombre Evento");
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Ingese Nombre del Evento:");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Ingese Descripción del Evento:");

        jTextField4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField4.setText("Lugar Evento");
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Ingese Lugar del Evento:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Ingese Fecha y Hora de Inicio:");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Ingese Fecha y Hora de Fin:");

        jButton6.setBackground(new java.awt.Color(255, 255, 0));
        jButton6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton6.setText("Agregar Evento");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel14.setText(":");

        jLabel15.setText(":");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Repetición Mensual (del año actual)", "Repetición Anual (próximos 5 años)", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Ingese Ciclo de Repetición del evento:");

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setText("Ingese Etiqueta del Evento:");

        jTextField7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField7.setText("Etiqueta");
        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField7FocusLost(evt);
            }
        });

        javax.swing.GroupLayout PanelAgregarEventosRepetitivosLayout = new javax.swing.GroupLayout(PanelAgregarEventosRepetitivos);
        PanelAgregarEventosRepetitivos.setLayout(PanelAgregarEventosRepetitivosLayout);
        PanelAgregarEventosRepetitivosLayout.setHorizontalGroup(
            PanelAgregarEventosRepetitivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelAgregarEventosRepetitivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                        .addGroup(PanelAgregarEventosRepetitivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                        .addGroup(PanelAgregarEventosRepetitivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelAgregarEventosRepetitivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                                .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(29, 29, 29)
                        .addGroup(PanelAgregarEventosRepetitivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                                .addComponent(jSpinField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                                .addComponent(jSpinField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(115, 115, 115))))
            .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jButton6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelAgregarEventosRepetitivosLayout.setVerticalGroup(
            PanelAgregarEventosRepetitivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAgregarEventosRepetitivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelAgregarEventosRepetitivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(PanelAgregarEventosRepetitivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelAgregarEventosRepetitivosLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(PanelAgregarEventosRepetitivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(PanelAgregarEventosRepetitivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(PanelAgregarEventosRepetitivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(PanelAgregarEventosRepetitivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(53, 53, 53)
                .addComponent(jButton6)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        PanelCambiante.add(PanelAgregarEventosRepetitivos, "cardAgregarEventosRepetitivos");

        PanelMostrarEventos.setBackground(new java.awt.Color(204, 204, 204));
        PanelMostrarEventos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Titulo", "Lugar", "FechaInicio", "FechaFinal", "Etiquetas"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout PanelMostrarEventosLayout = new javax.swing.GroupLayout(PanelMostrarEventos);
        PanelMostrarEventos.setLayout(PanelMostrarEventosLayout);
        PanelMostrarEventosLayout.setHorizontalGroup(
            PanelMostrarEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMostrarEventosLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelMostrarEventosLayout.setVerticalGroup(
            PanelMostrarEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMostrarEventosLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        PanelCambiante.add(PanelMostrarEventos, "cardMostrarEventos");

        PanelGenerarReporte.setBackground(new java.awt.Color(102, 255, 255));

        jLabel17.setText("Ingresar Nombre del Reporte:");

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("NombreReporte");
        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField5FocusLost(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 51));
        jButton8.setText("Generar Reporte");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelGenerarReporteLayout = new javax.swing.GroupLayout(PanelGenerarReporte);
        PanelGenerarReporte.setLayout(PanelGenerarReporteLayout);
        PanelGenerarReporteLayout.setHorizontalGroup(
            PanelGenerarReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGenerarReporteLayout.createSequentialGroup()
                .addGroup(PanelGenerarReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelGenerarReporteLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelGenerarReporteLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jButton8)))
                .addContainerGap(622, Short.MAX_VALUE))
        );
        PanelGenerarReporteLayout.setVerticalGroup(
            PanelGenerarReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGenerarReporteLayout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(PanelGenerarReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(jButton8)
                .addContainerGap(291, Short.MAX_VALUE))
        );

        PanelCambiante.add(PanelGenerarReporte, "cardGenerarReportes");

        PanelBuscarEventosPorMes.setBackground(new java.awt.Color(204, 204, 204));
        PanelBuscarEventosPorMes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Titulo", "Lugar", "FechaInicio", "FechaFinal", "Etiquetas"
            }
        ));
        jScrollPane5.setViewportView(jTable3);

        jLabel19.setText("Ingrese la Fecha de Eventos a Buscar:");

        jButton11.setBackground(new java.awt.Color(255, 255, 0));
        jButton11.setText("Buscar Eventos");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBuscarEventosPorMesLayout = new javax.swing.GroupLayout(PanelBuscarEventosPorMes);
        PanelBuscarEventosPorMes.setLayout(PanelBuscarEventosPorMesLayout);
        PanelBuscarEventosPorMesLayout.setHorizontalGroup(
            PanelBuscarEventosPorMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscarEventosPorMesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBuscarEventosPorMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelBuscarEventosPorMesLayout.createSequentialGroup()
                        .addGroup(PanelBuscarEventosPorMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelBuscarEventosPorMesLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(43, 43, 43)
                                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelBuscarEventosPorMesLayout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBuscarEventosPorMesLayout.setVerticalGroup(
            PanelBuscarEventosPorMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBuscarEventosPorMesLayout.createSequentialGroup()
                .addGroup(PanelBuscarEventosPorMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBuscarEventosPorMesLayout.createSequentialGroup()
                        .addGroup(PanelBuscarEventosPorMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelBuscarEventosPorMesLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBuscarEventosPorMesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelBuscarEventosPorMesLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton11)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        PanelCambiante.add(PanelBuscarEventosPorMes, "cardBuscarEventosPorMes");

        PanelBuscarEventosPorDia.setBackground(new java.awt.Color(204, 204, 204));
        PanelBuscarEventosPorDia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Titulo", "Lugar", "FechaInicio", "FechaFinal", "Etiquetas"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        jLabel18.setText("Ingrese la Fecha de Eventos a Buscar:");

        jButton9.setBackground(new java.awt.Color(255, 255, 0));
        jButton9.setText("Buscar Eventos");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBuscarEventosPorDiaLayout = new javax.swing.GroupLayout(PanelBuscarEventosPorDia);
        PanelBuscarEventosPorDia.setLayout(PanelBuscarEventosPorDiaLayout);
        PanelBuscarEventosPorDiaLayout.setHorizontalGroup(
            PanelBuscarEventosPorDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(PanelBuscarEventosPorDiaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelBuscarEventosPorDiaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(526, 526, 526))
        );
        PanelBuscarEventosPorDiaLayout.setVerticalGroup(
            PanelBuscarEventosPorDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscarEventosPorDiaLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(PanelBuscarEventosPorDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        PanelCambiante.add(PanelBuscarEventosPorDia, "cardBuscarEventosPorDia");

        PanelEliminarEventosPorID.setBackground(new java.awt.Color(102, 255, 255));
        PanelEliminarEventosPorID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelEliminarEventosPorID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTextField11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField11.setText("Nombre Evento");
        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField11FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField11FocusLost(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel33.setText("Ingese Nombre del Evento:");

        jLabel35.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel35.setText("Ingese Descripción del Evento:");

        jTextField12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField12.setText("Lugar Evento");
        jTextField12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField12FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField12FocusLost(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel36.setText("Ingese Lugar del Evento:");

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane10.setViewportView(jTextArea4);

        jLabel37.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel37.setText("Ingese Fecha y Hora de Inicio:");

        jLabel38.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel38.setText("Ingese Fecha y Hora de Fin:");

        jButton21.setBackground(new java.awt.Color(102, 102, 255));
        jButton21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton21.setText("Mostrar Datos del Evento a Eliminar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel41.setText("Ingese ID del Evento:");

        jButton22.setBackground(new java.awt.Color(255, 51, 51));
        jButton22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton22.setText("Eliminar Evento");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEliminarEventosPorIDLayout = new javax.swing.GroupLayout(PanelEliminarEventosPorID);
        PanelEliminarEventosPorID.setLayout(PanelEliminarEventosPorIDLayout);
        PanelEliminarEventosPorIDLayout.setHorizontalGroup(
            PanelEliminarEventosPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEliminarEventosPorIDLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(PanelEliminarEventosPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEliminarEventosPorIDLayout.createSequentialGroup()
                        .addGroup(PanelEliminarEventosPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelEliminarEventosPorIDLayout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelEliminarEventosPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PanelEliminarEventosPorIDLayout.createSequentialGroup()
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooser11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(PanelEliminarEventosPorIDLayout.createSequentialGroup()
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooser12, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelEliminarEventosPorIDLayout.createSequentialGroup()
                        .addGroup(PanelEliminarEventosPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelEliminarEventosPorIDLayout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton21))
                            .addGroup(PanelEliminarEventosPorIDLayout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelEliminarEventosPorIDLayout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 527, Short.MAX_VALUE))))
            .addGroup(PanelEliminarEventosPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelEliminarEventosPorIDLayout.createSequentialGroup()
                    .addGap(341, 341, 341)
                    .addComponent(jButton22)
                    .addContainerGap(592, Short.MAX_VALUE)))
        );
        PanelEliminarEventosPorIDLayout.setVerticalGroup(
            PanelEliminarEventosPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEliminarEventosPorIDLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelEliminarEventosPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jButton21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelEliminarEventosPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEliminarEventosPorIDLayout.createSequentialGroup()
                        .addGroup(PanelEliminarEventosPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEliminarEventosPorIDLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(PanelEliminarEventosPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelEliminarEventosPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(PanelEliminarEventosPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jDateChooser12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(336, 336, 336))
            .addGroup(PanelEliminarEventosPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEliminarEventosPorIDLayout.createSequentialGroup()
                    .addContainerGap(441, Short.MAX_VALUE)
                    .addComponent(jButton22)
                    .addGap(234, 234, 234)))
        );

        PanelCambiante.add(PanelEliminarEventosPorID, "cardEliminarEventosPorID");

        PanelBuscarEventosPorSemana.setBackground(new java.awt.Color(204, 204, 204));
        PanelBuscarEventosPorSemana.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Titulo", "Lugar", "FechaInicio", "FechaFinal", "Etiquetas"
            }
        ));
        jScrollPane6.setViewportView(jTable4);

        jLabel20.setText("Ingrese Fecha de Inicio Para Buscar Eventos En Los Siguientes 7 días:");

        jButton13.setBackground(new java.awt.Color(255, 255, 0));
        jButton13.setText("Buscar Eventos");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBuscarEventosPorSemanaLayout = new javax.swing.GroupLayout(PanelBuscarEventosPorSemana);
        PanelBuscarEventosPorSemana.setLayout(PanelBuscarEventosPorSemanaLayout);
        PanelBuscarEventosPorSemanaLayout.setHorizontalGroup(
            PanelBuscarEventosPorSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(PanelBuscarEventosPorSemanaLayout.createSequentialGroup()
                .addGroup(PanelBuscarEventosPorSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBuscarEventosPorSemanaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13))
                    .addGroup(PanelBuscarEventosPorSemanaLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        PanelBuscarEventosPorSemanaLayout.setVerticalGroup(
            PanelBuscarEventosPorSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscarEventosPorSemanaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(PanelBuscarEventosPorSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        PanelCambiante.add(PanelBuscarEventosPorSemana, "cardBuscarEventosPorSemana");

        PanelBuscarEventosPorTramos.setBackground(new java.awt.Color(204, 204, 204));
        PanelBuscarEventosPorTramos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Titulo", "Lugar", "FechaInicio", "FechaFinal", "Etiquetas"
            }
        ));
        jScrollPane7.setViewportView(jTable5);

        jLabel21.setText("Ingrese Fecha de Inicio del Tramo:");

        jButton15.setBackground(new java.awt.Color(255, 255, 0));
        jButton15.setText("Buscar Eventos");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel22.setText("Ingrese Fecha de Fin del Tramo:");

        javax.swing.GroupLayout PanelBuscarEventosPorTramosLayout = new javax.swing.GroupLayout(PanelBuscarEventosPorTramos);
        PanelBuscarEventosPorTramos.setLayout(PanelBuscarEventosPorTramosLayout);
        PanelBuscarEventosPorTramosLayout.setHorizontalGroup(
            PanelBuscarEventosPorTramosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscarEventosPorTramosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(PanelBuscarEventosPorTramosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBuscarEventosPorTramosLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelBuscarEventosPorTramosLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBuscarEventosPorTramosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(704, 704, 704))
        );
        PanelBuscarEventosPorTramosLayout.setVerticalGroup(
            PanelBuscarEventosPorTramosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscarEventosPorTramosLayout.createSequentialGroup()
                .addGroup(PanelBuscarEventosPorTramosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBuscarEventosPorTramosLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(PanelBuscarEventosPorTramosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(PanelBuscarEventosPorTramosLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelBuscarEventosPorTramosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBuscarEventosPorTramosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton15)
                        .addGap(41, 41, 41)))
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        PanelCambiante.add(PanelBuscarEventosPorTramos, "cardBuscarEventosPorTramos");

        PanelBuscarEventosPorEtiquetas.setBackground(new java.awt.Color(204, 204, 204));
        PanelBuscarEventosPorEtiquetas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Titulo", "Lugar", "FechaInicio", "FechaFinal", "Etiquetas"
            }
        ));
        jScrollPane8.setViewportView(jTable6);

        jButton18.setBackground(new java.awt.Color(255, 255, 0));
        jButton18.setText("Buscar Eventos");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel23.setText("Ingrese Nombre de la Etiqueta a Buscar:");

        jTextField6.setText("NombreEtiqueta");

        javax.swing.GroupLayout PanelBuscarEventosPorEtiquetasLayout = new javax.swing.GroupLayout(PanelBuscarEventosPorEtiquetas);
        PanelBuscarEventosPorEtiquetas.setLayout(PanelBuscarEventosPorEtiquetasLayout);
        PanelBuscarEventosPorEtiquetasLayout.setHorizontalGroup(
            PanelBuscarEventosPorEtiquetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(PanelBuscarEventosPorEtiquetasLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelBuscarEventosPorEtiquetasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(780, 780, 780))
        );
        PanelBuscarEventosPorEtiquetasLayout.setVerticalGroup(
            PanelBuscarEventosPorEtiquetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscarEventosPorEtiquetasLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(PanelBuscarEventosPorEtiquetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jLabel23)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        PanelCambiante.add(PanelBuscarEventosPorEtiquetas, "cardBuscarEventosPorEtiquetas");

        PanelEditarEventoPorID.setBackground(new java.awt.Color(102, 255, 255));
        PanelEditarEventoPorID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelEditarEventoPorID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTextField9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField9.setText("Nombre Evento");
        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField9FocusLost(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setText("Ingese Nombre del Evento:");

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setText("Ingese Descripción del Evento:");

        jTextField10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField10.setText("Lugar Evento");
        jTextField10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField10FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField10FocusLost(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel28.setText("Ingese Lugar del Evento:");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane9.setViewportView(jTextArea3);

        jLabel29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel29.setText("Ingese Fecha y Hora de Inicio:");

        jLabel30.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel30.setText("Ingese Fecha y Hora de Fin:");

        jButton19.setBackground(new java.awt.Color(255, 255, 0));
        jButton19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton19.setText("Modificar Evento");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel31.setText(":");

        jLabel32.setText(":");

        jLabel34.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel34.setText("Ingese ID del Evento:");

        javax.swing.GroupLayout PanelEditarEventoPorIDLayout = new javax.swing.GroupLayout(PanelEditarEventoPorID);
        PanelEditarEventoPorID.setLayout(PanelEditarEventoPorIDLayout);
        PanelEditarEventoPorIDLayout.setHorizontalGroup(
            PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                        .addGroup(PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                                .addGap(290, 290, 290)
                                .addComponent(jButton19))
                            .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                                .addGroup(PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jDateChooser9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jDateChooser10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jSpinField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jSpinField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(515, Short.MAX_VALUE))
                    .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                        .addGroup(PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelEditarEventoPorIDLayout.setVerticalGroup(
            PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                        .addGroup(PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEditarEventoPorIDLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEditarEventoPorIDLayout.createSequentialGroup()
                        .addGroup(PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinField10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(71, 71, 71)
                        .addGroup(PanelEditarEventoPorIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jDateChooser10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addGap(71, 71, 71)
                        .addComponent(jButton19))
                    .addComponent(jSpinField9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(244, 244, 244))
        );

        PanelCambiante.add(PanelEditarEventoPorID, "cardEditarEventosPorID");

        jButton10.setForeground(new java.awt.Color(0, 204, 153));
        jButton10.setText("Buscar Eventos Por Mes");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setForeground(new java.awt.Color(0, 204, 153));
        jButton12.setText("Buscar Eventos Por Semanas");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton14.setForeground(new java.awt.Color(0, 204, 153));
        jButton14.setText("Buscar Eventos Por Tramos");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton16.setForeground(new java.awt.Color(0, 204, 153));
        jButton16.setText("Buscar Evento Por Etiquetas");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setForeground(new java.awt.Color(0, 204, 153));
        jButton17.setText("Editar Evento Por ID");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton20.setForeground(new java.awt.Color(0, 204, 153));
        jButton20.setText("Eliminar Evento Por ID");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(202, 202, 202)
                        .addComponent(PanelCambiante, javax.swing.GroupLayout.PREFERRED_SIZE, 1051, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCambiante, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        cardLayout = (CardLayout) this.PanelCambiante.getLayout();
        cardLayout.show(PanelCambiante, "cardMostrarEventos");
        
        
        // Obtener la lista de eventos
        List<Evento> eventos = agenda.getEventosEnlistados();
        
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
                new Object[]{"ID", "Titulo", "Lugar", "FechaInicio", "FechaFin", "Etiquetas"}, 0
        );
        // Limpiar el modelo antes de añadir filas nuevas
        modelo.setRowCount(0);
        
        // Recorrer la lista de eventos y añadir filas al modelo
        for (Evento evento : eventos) {
            Object[] fila = new Object[6]; // 6 columnas: ID, Titulo, Lugar, FechaInicio, FechaFin, Etiquetas
            
            fila[0] = evento.getId(); // Añadir ID del evento
            fila[1] = evento.getTitulo(); // Título del evento
            fila[2] = evento.getLugar(); // Lugar del evento
            fila[3] = evento.getFechaInicio().format(DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm")); // Fecha de inicio
            fila[4] = evento.getFechaFin().format(DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm")); // Fecha de fin
            
            // Convertir el array de etiquetas en un string para mostrarlo en una celda
            List<Etiqueta> etiquetas = evento.getEtiquetas();
            String etiquetasStr = etiquetas.stream()
                    .map(Etiqueta::getNombre) // Obtener el nombre de cada etiqueta
                    .reduce((acc, nombre) -> acc + ", " + nombre) // Unirlas en un string
                    .orElse(""); // En caso de que no haya etiquetas
            
            fila[5] = etiquetasStr; // Añadir la cadena de etiquetas a la fila
            
            // Añadir la fila al modelo
            modelo.addRow(fila);
        }
        
        jTable1.setModel(modelo);
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jButton2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jButton2StateChanged
        
    }//GEN-LAST:event_jButton2StateChanged
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        cardLayout = (CardLayout) this.PanelCambiante.getLayout();
        cardLayout.show(PanelCambiante, "cardAgregarEventosSimples");
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Recuperar los datos de los campos de texto
        String titulo = jTextField1.getText(); // Campo para nombre del evento
        String descripcion = jTextArea1.getText(); // Campo para descripción
        String lugar = jTextField2.getText(); // Campo para lugar
        String nombreEtiqueta = jTextField8.getText(); // Campo para lugar
        int id = agenda.getEventosEnlistadosLargo();
        
        Etiqueta nuevaEtiqueta = new Etiqueta(id, nombreEtiqueta);
        
        // Obtener la fecha de los JDateChooser
        Date fechaHoraInicioDate = jDateChooser1.getDate(); // Campo para fecha y hora de inicio
        Date fechaHoraFinDate = jDateChooser2.getDate(); // Campo para fecha y hora de fin
        
        // Obtener la hora y el minuto de los jSpinFields
        int horaInicio = jSpinField1.getValue();
        int minutoInicio = jSpinField2.getValue();
        int horaFinal = jSpinField3.getValue();
        int minutoFinal = jSpinField4.getValue();
        
        // Validar los campos
        if (titulo.isEmpty() || descripcion.isEmpty() || lugar.isEmpty() || fechaHoraInicioDate == null || fechaHoraFinDate == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validar que las horas estén en el rango de 0 a 23 y los minutos en el rango de 0 a 59
        if (horaInicio < 0 || horaInicio > 23 || horaFinal < 0 || horaFinal > 23 || minutoInicio < 0 || minutoInicio > 59 || minutoFinal < 0 || minutoFinal > 59) {
            JOptionPane.showMessageDialog(this, "Las horas deben estar entre 0 y 23, y los minutos entre 0 y 59.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Convertir Date a LocalDateTime y añadir las horas y minutos
        LocalDateTime fechaHoraInicio = fechaHoraInicioDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                .withHour(horaInicio).withMinute(minutoInicio);
        LocalDateTime fechaHoraFin = fechaHoraFinDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                .withHour(horaFinal).withMinute(minutoFinal);
        
        // Verificar que la fecha final sea posterior o igual a la fecha de inicio
        if (fechaHoraFin.isBefore(fechaHoraInicio)) {
            JOptionPane.showMessageDialog(this, "La fecha de fin debe ser posterior o igual a la fecha de inicio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Definir el formato de la fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"); // Ajustar el patrón según necesites
        
        try {
            // Validar el formato de las fechas
            String fechaHoraInicioStr = fechaHoraInicio.format(formatter);
            String fechaHoraFinStr = fechaHoraFin.format(formatter);
            
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha y hora inválido. Use 'dd-MM-yyyy HH:mm'.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Crear un nuevo evento
        Evento nuevoEvento = new Evento(id, titulo, descripcion, fechaHoraInicio, fechaHoraFin, lugar);
        nuevoEvento.agregarEtiqueta(nuevaEtiqueta);
        agenda.agregarEvento(nuevoEvento);
        
        // Limpiar los campos después de agregar el evento
        jTextField1.setText("");
        jTextArea1.setText("");
        jTextField2.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jSpinField1.setValue(0);
        jSpinField2.setValue(0);
        jSpinField3.setValue(0);
        jSpinField4.setValue(0);
        
        // Confirmación al usuario
        gestorDeDatos.guardarDatos();
        JOptionPane.showMessageDialog(this, "¡Evento agregado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        if (jTextField1.getText().equals("")) {
            jTextField1.setText("Nombre Evento"); // Limpia el texto del placeholder
            jTextField1.setForeground(new Color(153,153,153)); // Cambia el color a negro
        }
    }//GEN-LAST:event_jTextField1FocusLost
    
    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        // TODO add your handling code here:
        if (jTextField1.getText().equals("Nombre Evento")) {
            jTextField1.setText(""); // Limpia el texto del placeholder
            jTextField1.setForeground(new Color(153,153,153)); // Cambia el color a negro
        }
    }//GEN-LAST:event_jTextField1FocusGained
    
    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        if (jTextField2.getText().equals("")) {
            jTextField2.setText("Lugar Evento"); // Limpia el texto del placeholder
            jTextField2.setForeground(new Color(153,153,153)); // Cambia el color a negro
        }
    }//GEN-LAST:event_jTextField2FocusLost
    
    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        // TODO add your handling code here:
        if (jTextField2.getText().equals("Lugar Evento")) {
            jTextField2.setText(""); // Limpia el texto del placeholder
            jTextField2.setForeground(new Color(153,153,153)); // Cambia el color a negro
        }
    }//GEN-LAST:event_jTextField2FocusGained
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        cardLayout = (CardLayout) this.PanelCambiante.getLayout();
        cardLayout.show(PanelCambiante, "cardAgregarEventosRepetitivos");
    }//GEN-LAST:event_jButton5ActionPerformed
    
    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        if (jTextField3.getText().equals("Nombre Evento")) {
            jTextField3.setText(""); // Limpia el texto del placeholder
            jTextField3.setForeground(new Color(153,153,153)); // Cambia el color a negro
        }
    }//GEN-LAST:event_jTextField3FocusGained
    
    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        if (jTextField3.getText().equals("")) {
            jTextField3.setText("Nombre Evento"); // Limpia el texto del placeholder
            jTextField3.setForeground(new Color(153,153,153)); // Cambia el color a negro
        }
    }//GEN-LAST:event_jTextField3FocusLost
    
    private void jTextField4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusGained
        if (jTextField4.getText().equals("Lugar Evento")) {
            jTextField4.setText(""); // Limpia el texto del placeholder
            jTextField4.setForeground(new Color(153,153,153)); // Cambia el color a negro
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4FocusGained
    
    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        if (jTextField4.getText().equals("")) {
            jTextField4.setText("Lugar Evento"); // Limpia el texto del placeholder
            jTextField4.setForeground(new Color(153,153,153)); // Cambia el color a negro
        }
    }//GEN-LAST:event_jTextField4FocusLost
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Repetición Mensual (del año actual)
        //Repetición Anual (próximos 5 años)
        String cicloRepeticion = (String) jComboBox1.getSelectedItem(); // Obtener valor del campo de repetición
        
        
        String titulo = jTextField3.getText(); // Campo para nombre del evento
        String descripcion = jTextArea2.getText(); // Campo para descripción
        String lugar = jTextField4.getText(); // Campo para lugar
        String nombreEtiqueta = jTextField7.getText(); // Campo para lugar
        int id = agenda.getEventosEnlistadosLargo();
        Etiqueta nuevaEtiqueta = new Etiqueta(id, nombreEtiqueta);
        
        // Obtener la fecha de los JDateChooser
        Date fechaHoraInicioDate = jDateChooser3.getDate(); // Campo para fecha y hora de inicio
        Date fechaHoraFinDate = jDateChooser4.getDate(); // Campo para fecha y hora de fin
        
        // Obtener la hora y el minuto de los jSpinFields
        int horaInicio = jSpinField5.getValue();
        int minutoInicio = jSpinField6.getValue();
        int horaFinal = jSpinField7.getValue();
        int minutoFinal = jSpinField8.getValue();
        
        // Validar los campos
        if (titulo.isEmpty() || descripcion.isEmpty() || lugar.isEmpty() || fechaHoraInicioDate == null || fechaHoraFinDate == null || cicloRepeticion == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        // Validar que las horas estén en el rango de 0 a 23 y los minutos en el rango de 0 a 59
        if (horaInicio < 0 || horaInicio > 23 || horaFinal < 0 || horaFinal > 23 || minutoInicio < 0 || minutoInicio > 59 || minutoFinal < 0 || minutoFinal > 59) {
            JOptionPane.showMessageDialog(this, "Las horas deben estar entre 0 y 23, y los minutos entre 0 y 59.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Convertir Date a LocalDateTime y añadir las horas y minutos
        LocalDateTime fechaHoraInicio = fechaHoraInicioDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                .withHour(horaInicio).withMinute(minutoInicio);
        LocalDateTime fechaHoraFin = fechaHoraFinDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                .withHour(horaFinal).withMinute(minutoFinal);
        
        // Verificar que la fecha final sea posterior o igual a la fecha de inicio
        if (fechaHoraFin.isBefore(fechaHoraInicio)) {
            JOptionPane.showMessageDialog(this, "La fecha de fin debe ser posterior o igual a la fecha de inicio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Definir el formato de la fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"); // Ajustar el patrón según necesites
        
        try {
            String fechaHoraInicioStr = fechaHoraInicio.format(formatter);
            String fechaHoraFinStr = fechaHoraFin.format(formatter);
            
            
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha y hora inválido. Use 'dd-MM-yyyy HH:mm'.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Crear el evento dependiendo del ciclo de repetición seleccionado
        Evento nuevoEvento;
        if (cicloRepeticion.equals("Repetición Anual (próximos 5 años)")) {
            // Crear un evento que se repita cada año durante 5 años
            nuevoEvento = new EventosAnuales(id, titulo, descripcion, fechaHoraInicio, fechaHoraFin, lugar);
            nuevoEvento.agregarEtiqueta(nuevaEtiqueta);
            nuevoEvento.agendarEvento(agenda); // Agregar el evento a la agenda
            
        } else if (cicloRepeticion.equals("Repetición Mensual (del año actual)")) {
            // Crear un evento que se repita todos los meses del año actual
            nuevoEvento = new EventosMensuales(id, titulo, descripcion, fechaHoraInicio, fechaHoraFin, lugar);
            nuevoEvento.agendarEvento(agenda); // Agregar el evento a la agenda
            
        } else {
            JOptionPane.showMessageDialog(this, "Opción Inválida, Intente de Nuevo...", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Limpiar los campos después de agregar el evento
        jTextField3.setText("");
        jTextArea2.setText("");
        jTextField4.setText("");
        jDateChooser3.setDate(null);
        jDateChooser4.setDate(null);
        jSpinField5.setValue(0);
        jSpinField6.setValue(0);
        jSpinField7.setValue(0);
        jSpinField8.setValue(0);
        jComboBox1.setSelectedItem(null);
        // Confirmación al usuario
        gestorDeDatos.guardarDatos();
        JOptionPane.showMessageDialog(this, "¡Evento agregado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton6ActionPerformed
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        cardLayout = (CardLayout) this.PanelCambiante.getLayout();
        cardLayout.show(PanelCambiante, "cardGenerarReportes");
        
    }//GEN-LAST:event_jButton7ActionPerformed
    
    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String nombreReporte = jTextField5.getText();
        try{
            gestorDeDatos.generarReporteEventos(nombreReporte);
            JOptionPane.showMessageDialog(this, "¡Reporte generado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (PersistenciaException e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al generar el reporte...", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButton8ActionPerformed
    
    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusGained
        if (jTextField5.getText().equals("NombreReporte")) {
            jTextField5.setText(""); // Limpia el texto del placeholder
            jTextField5.setForeground(new Color(153,153,153)); // Cambia el color a negro
        }
    }//GEN-LAST:event_jTextField5FocusGained
    
    private void jTextField5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusLost
        if (jTextField5.getText().equals("")) {
            jTextField5.setText("NombreReporte"); // Limpia el texto del placeholder
            jTextField5.setForeground(new Color(153,153,153)); // Cambia el color a negro
        }
    }//GEN-LAST:event_jTextField5FocusLost
    
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Date fechaIngresada = jDateChooser5.getDate();
        
        if ((fechaIngresada == null )) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        LocalDate fechaMod = fechaIngresada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        int dia = fechaMod.getDayOfMonth();
        int mes = fechaMod.getMonthValue();
        int anio = fechaMod.getYear();
        
        String anioString = String.valueOf(anio);
        String mesString = String.format("%02d", mes);
        
        javax.swing.table.DefaultTableModel modelo = agenda.buscarEventosPorFecha(dia, mesString, anioString);
        
        if(modelo == null) {
            JOptionPane.showMessageDialog(this, "No hay eventos para ese día", "Atención!", JOptionPane.ERROR_MESSAGE);
        } else {
            jTable2.setModel(modelo);
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cardLayout = (CardLayout) this.PanelCambiante.getLayout();
        cardLayout.show(PanelCambiante, "cardBuscarEventosPorDia");
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        cardLayout = (CardLayout) this.PanelCambiante.getLayout();
        cardLayout.show(PanelCambiante, "cardBuscarEventosPorMes");
    }//GEN-LAST:event_jButton10ActionPerformed
    
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int mesIngresado = jMonthChooser1.getMonth()+1;
        int anioIngresado = jYearChooser1.getYear();
        
        if ((mesIngresado == 0 )|| (anioIngresado == 0)) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String anioString = String.valueOf(anioIngresado);
        String mesString = String.format("%02d", mesIngresado);
        
        javax.swing.table.DefaultTableModel modelo = agenda.buscarEventosPorMes(mesString, anioString);
        
        if(modelo == null) {
            JOptionPane.showMessageDialog(this, "No hay eventos para ese día", "Atención!", JOptionPane.ERROR_MESSAGE);
        } else {
            jTable3.setModel(modelo);
        }
    }//GEN-LAST:event_jButton11ActionPerformed
    
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        cardLayout = (CardLayout) this.PanelCambiante.getLayout();
        cardLayout.show(PanelCambiante, "cardBuscarEventosPorSemana");
    }//GEN-LAST:event_jButton12ActionPerformed
    
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        Date fechaIngresada = jDateChooser6.getDate();
        
        // Validar los campos
        if (fechaIngresada == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        LocalDate fechaMod = fechaIngresada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        // Formatear la fecha en formato "dd-MM-yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fechaMod.format(formatter);
        
        String anioString = String.valueOf(fechaMod.getYear());
        
        javax.swing.table.DefaultTableModel modelo = agenda.buscarEventosPorFecha(fechaFormateada, anioString);
        
        if(modelo == null) {
            JOptionPane.showMessageDialog(this, "No hay eventos para ese día", "Atención!", JOptionPane.ERROR_MESSAGE);
        } else {
            jTable4.setModel(modelo);
        }
    }//GEN-LAST:event_jButton13ActionPerformed
    
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        cardLayout = (CardLayout) this.PanelCambiante.getLayout();
        cardLayout.show(PanelCambiante, "cardBuscarEventosPorTramos");
    }//GEN-LAST:event_jButton14ActionPerformed
    
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        Date fechaInicio = jDateChooser7.getDate();
        Date fechaFin = jDateChooser8.getDate();
        
        // Validar los campos
        if (fechaInicio == null || fechaFin == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        LocalDateTime fechaInicioMod = fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime fechaFinMod = fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        
        // Verificar que la fecha final no sea anterior a la fecha inicial
        if (fechaFinMod.isBefore(fechaInicioMod)) {
            JOptionPane.showMessageDialog(this, "La fecha de fin no puede ser anterior a la fecha de inicio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        javax.swing.table.DefaultTableModel modelo = agenda.filtrarEventosPorRangoFechas(fechaInicioMod, fechaFinMod);
        
        if(modelo == null) {
            JOptionPane.showMessageDialog(this, "No hay eventos para ese tramo", "Atención!", JOptionPane.ERROR_MESSAGE);
        } else {
            jTable5.setModel(modelo);
        }
    }//GEN-LAST:event_jButton15ActionPerformed
    
    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        cardLayout = (CardLayout) this.PanelCambiante.getLayout();
        cardLayout.show(PanelCambiante, "cardBuscarEventosPorEtiquetas");
    }//GEN-LAST:event_jButton16ActionPerformed
    
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        String nombreEtiqueta = jTextField6.getText();
        
        // Validar los campos
        if (nombreEtiqueta == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Etiqueta etiquetaBuscada = new Etiqueta(0, nombreEtiqueta);
        
        javax.swing.table.DefaultTableModel modelo = agenda.buscarEventosPorEtiqueta(etiquetaBuscada);
        
        if(modelo == null) {
            JOptionPane.showMessageDialog(this, "No hay eventos para esa etiqueta", "Atención!", JOptionPane.ERROR_MESSAGE);
        } else {
            jTable6.setModel(modelo);
        }
        
    }//GEN-LAST:event_jButton18ActionPerformed
    
    private void jTextField7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusGained
    
    private void jTextField7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusLost
    
    private void jTextField8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8FocusGained
    
    private void jTextField8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8FocusLost
    
    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        cardLayout = (CardLayout) this.PanelCambiante.getLayout();
        cardLayout.show(PanelCambiante, "cardEditarEventosPorID");
    }//GEN-LAST:event_jButton17ActionPerformed
    
    private void jTextField9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9FocusGained
    
    private void jTextField9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9FocusLost
    
    private void jTextField10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10FocusGained
    
    private void jTextField10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10FocusLost
    
    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        int idBuscado = jSpinField13.getValue();
        agenda.editarEventoPorId(idBuscado,jTextField9, jTextArea3, jTextField10, jDateChooser9, jDateChooser10);
        
        jSpinField13.setValue(0);
        jTextField9.setText("");
        jTextArea3.setText("");
        jTextField10.setText("");
        jDateChooser9.setDate(null);
        jDateChooser10.setDate(null);
    }//GEN-LAST:event_jButton19ActionPerformed
    
    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        cardLayout = (CardLayout) this.PanelCambiante.getLayout();
        cardLayout.show(PanelCambiante, "cardEliminarEventosPorID");
    }//GEN-LAST:event_jButton20ActionPerformed
    
    private void jTextField11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusGained
    
    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusLost
    
    private void jTextField12FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12FocusGained
    
    private void jTextField12FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12FocusLost
    
    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // Obtener el ID del evento desde el JSpinner o campo de texto
        int idEvento = (int) jSpinField18.getValue(); // Asegúrate de que jSpinnerEventoID esté configurado correctamente
        
        // Obtener la instancia de la Agenda
        Agenda agenda = Agenda.getInstancia();
        
        // Buscar el evento usando el ID
        Evento evento = agenda.buscarEventoPorId(idEvento);
        
        if (evento == null) {
            JOptionPane.showMessageDialog(this, "No se encontró un evento con el ID proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Terminar si el evento no existe
        }
        
        // Rellenar los campos con los datos del evento encontrado
        jTextField11.setText(evento.getTitulo());
        jTextArea4.setText(evento.getDescripcion());
        jTextField12.setText(evento.getLugar());
        jDateChooser11.setDate(Date.from(evento.getFechaInicio().atZone(ZoneId.systemDefault()).toInstant()));
        jDateChooser12.setDate(Date.from(evento.getFechaFin().atZone(ZoneId.systemDefault()).toInstant()));
        
        // Mensaje de confirmación
        JOptionPane.showMessageDialog(this, "Datos del evento cargados.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton21ActionPerformed
    
    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // Obtener el ID del evento a eliminar desde el JSpinner o campo de texto
        int idEventoEliminar = (int) jSpinField18.getValue(); // Asegúrate de que jSpinnerEventoID esté configurado correctamente
        
        // Buscar el evento usando el ID
        Evento evento = agenda.buscarEventoPorId(idEventoEliminar);
        
        if (evento == null) {
            JOptionPane.showMessageDialog(this, "No se encontró un evento con el ID proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Terminar si el evento no existe
        }
        
        // Preguntar al usuario si realmente desea eliminar el evento
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este evento?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Eliminar el evento usando el ID
            agenda.eliminarEvento(idEventoEliminar);
            
            // Mostrar mensaje al usuario
            
            JOptionPane.showMessageDialog(this, "Evento eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            // Limpiar los campos después de eliminar
            jTextField11.setText("");
            jTextArea4.setText("");
            jTextField12.setText("");
            jDateChooser11.setDate(null);
            jDateChooser12.setDate(null);
            // Limpiar el JSpinner o campo de texto
            jSpinField18.setValue(0); // Restablecer el valor del ID
        }
        
        
    }//GEN-LAST:event_jButton22ActionPerformed
    
    
    
    //JPopupMenu popMenu = new JPopupMenu();
    //JMenuItem eliminarEvento = new JMenuItem("Eliminar evento");
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAgregarEventosRepetitivos;
    private javax.swing.JPanel PanelAgregarEventosSimples;
    private javax.swing.JPanel PanelBuscarEventosPorDia;
    private javax.swing.JPanel PanelBuscarEventosPorEtiquetas;
    private javax.swing.JPanel PanelBuscarEventosPorMes;
    private javax.swing.JPanel PanelBuscarEventosPorSemana;
    private javax.swing.JPanel PanelBuscarEventosPorTramos;
    private javax.swing.JPanel PanelCambiante;
    private javax.swing.JPanel PanelEditarEventoPorID;
    private javax.swing.JPanel PanelEliminarEventosPorID;
    private javax.swing.JPanel PanelGenerarReporte;
    private javax.swing.JPanel PanelMostrarEventos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser10;
    private com.toedter.calendar.JDateChooser jDateChooser11;
    private com.toedter.calendar.JDateChooser jDateChooser12;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private com.toedter.calendar.JDateChooser jDateChooser9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private com.toedter.components.JSpinField jSpinField1;
    private com.toedter.components.JSpinField jSpinField10;
    private com.toedter.components.JSpinField jSpinField11;
    private com.toedter.components.JSpinField jSpinField12;
    private com.toedter.components.JSpinField jSpinField13;
    private com.toedter.components.JSpinField jSpinField18;
    private com.toedter.components.JSpinField jSpinField2;
    private com.toedter.components.JSpinField jSpinField3;
    private com.toedter.components.JSpinField jSpinField4;
    private com.toedter.components.JSpinField jSpinField5;
    private com.toedter.components.JSpinField jSpinField6;
    private com.toedter.components.JSpinField jSpinField7;
    private com.toedter.components.JSpinField jSpinField8;
    private com.toedter.components.JSpinField jSpinField9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    // End of variables declaration//GEN-END:variables
}
