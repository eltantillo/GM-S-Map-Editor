namespace GMSMapEditor
{
    partial class MainWindow
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MainWindow));
            this.toolBar = new System.Windows.Forms.ToolStrip();
            this.toolStripButton1 = new System.Windows.Forms.ToolStripButton();
            this.toolStripButton2 = new System.Windows.Forms.ToolStripButton();
            this.toolStripButton3 = new System.Windows.Forms.ToolStripButton();
            this.toolStripSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.toggleProjectFiles = new System.Windows.Forms.ToolStripButton();
            this.splitContainer1 = new System.Windows.Forms.SplitContainer();
            this.splitContainer2 = new System.Windows.Forms.SplitContainer();
            this.roomSettingsTab = new System.Windows.Forms.TabControl();
            this.tilesTab = new System.Windows.Forms.TabPage();
            this.div_left = new System.Windows.Forms.Panel();
            this.tileBox = new System.Windows.Forms.PictureBox();
            this.objectsTab = new System.Windows.Forms.TabPage();
            this.resourcesTabs = new System.Windows.Forms.TabControl();
            this.roomsTab = new System.Windows.Forms.TabPage();
            this.roomsList = new System.Windows.Forms.ListBox();
            this.treeView1 = new System.Windows.Forms.TreeView();
            this.tabPage4 = new System.Windows.Forms.TabPage();
            this.menuBar = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.newProjectToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.openProjectToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.saveProjectToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.closeProjectToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem1 = new System.Windows.Forms.ToolStripSeparator();
            this.exitMapEditorToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.editToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.viewToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.modeToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.drawToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.scaleToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.gameToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.helpToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.statusBar = new System.Windows.Forms.StatusStrip();
            this.mapBox = new System.Windows.Forms.PictureBox();
            this.div_center = new System.Windows.Forms.Panel();
            this.toolBar.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).BeginInit();
            this.splitContainer1.Panel1.SuspendLayout();
            this.splitContainer1.Panel2.SuspendLayout();
            this.splitContainer1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer2)).BeginInit();
            this.splitContainer2.Panel1.SuspendLayout();
            this.splitContainer2.Panel2.SuspendLayout();
            this.splitContainer2.SuspendLayout();
            this.roomSettingsTab.SuspendLayout();
            this.tilesTab.SuspendLayout();
            this.div_left.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.tileBox)).BeginInit();
            this.resourcesTabs.SuspendLayout();
            this.roomsTab.SuspendLayout();
            this.menuBar.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.mapBox)).BeginInit();
            this.div_center.SuspendLayout();
            this.SuspendLayout();
            // 
            // toolBar
            // 
            this.toolBar.GripStyle = System.Windows.Forms.ToolStripGripStyle.Hidden;
            this.toolBar.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripButton1,
            this.toolStripButton2,
            this.toolStripButton3,
            this.toolStripSeparator1,
            this.toggleProjectFiles});
            this.toolBar.Location = new System.Drawing.Point(0, 24);
            this.toolBar.Name = "toolBar";
            this.toolBar.Size = new System.Drawing.Size(904, 25);
            this.toolBar.TabIndex = 1;
            this.toolBar.Text = "toolStrip1";
            // 
            // toolStripButton1
            // 
            this.toolStripButton1.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton1.Image = ((System.Drawing.Image)(resources.GetObject("toolStripButton1.Image")));
            this.toolStripButton1.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton1.Name = "toolStripButton1";
            this.toolStripButton1.Size = new System.Drawing.Size(23, 22);
            this.toolStripButton1.Text = "New Project...";
            this.toolStripButton1.Click += new System.EventHandler(this.toolStripButton1_Click);
            // 
            // toolStripButton2
            // 
            this.toolStripButton2.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton2.Image = global::GMSMapEditor.Properties.Resources.openProject;
            this.toolStripButton2.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton2.Name = "toolStripButton2";
            this.toolStripButton2.Size = new System.Drawing.Size(23, 22);
            this.toolStripButton2.Text = "Open Project...";
            this.toolStripButton2.Click += new System.EventHandler(this.toolStripButton2_Click);
            // 
            // toolStripButton3
            // 
            this.toolStripButton3.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton3.Image = global::GMSMapEditor.Properties.Resources.saveProject;
            this.toolStripButton3.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButton3.Name = "toolStripButton3";
            this.toolStripButton3.Size = new System.Drawing.Size(23, 22);
            this.toolStripButton3.Text = "Save Project";
            this.toolStripButton3.Click += new System.EventHandler(this.toolStripButton3_Click);
            // 
            // toolStripSeparator1
            // 
            this.toolStripSeparator1.Name = "toolStripSeparator1";
            this.toolStripSeparator1.Size = new System.Drawing.Size(6, 25);
            // 
            // toggleProjectFiles
            // 
            this.toggleProjectFiles.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toggleProjectFiles.Image = global::GMSMapEditor.Properties.Resources.projectFiles;
            this.toggleProjectFiles.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toggleProjectFiles.Name = "toggleProjectFiles";
            this.toggleProjectFiles.Size = new System.Drawing.Size(23, 22);
            this.toggleProjectFiles.Text = "Toggle Project Files";
            this.toggleProjectFiles.Click += new System.EventHandler(this.toggleProjectFiles_Click);
            // 
            // splitContainer1
            // 
            this.splitContainer1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer1.Location = new System.Drawing.Point(0, 49);
            this.splitContainer1.Name = "splitContainer1";
            // 
            // splitContainer1.Panel1
            // 
            this.splitContainer1.Panel1.Controls.Add(this.splitContainer2);
            // 
            // splitContainer1.Panel2
            // 
            this.splitContainer1.Panel2.AccessibleName = "resourcesPanel";
            this.splitContainer1.Panel2.Controls.Add(this.resourcesTabs);
            this.splitContainer1.Size = new System.Drawing.Size(904, 339);
            this.splitContainer1.SplitterDistance = 748;
            this.splitContainer1.SplitterWidth = 3;
            this.splitContainer1.TabIndex = 3;
            // 
            // splitContainer2
            // 
            this.splitContainer2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer2.Location = new System.Drawing.Point(0, 0);
            this.splitContainer2.Name = "splitContainer2";
            // 
            // splitContainer2.Panel1
            // 
            this.splitContainer2.Panel1.Controls.Add(this.roomSettingsTab);
            // 
            // splitContainer2.Panel2
            // 
            this.splitContainer2.Panel2.Controls.Add(this.div_center);
            this.splitContainer2.Size = new System.Drawing.Size(748, 339);
            this.splitContainer2.SplitterDistance = 150;
            this.splitContainer2.SplitterWidth = 3;
            this.splitContainer2.TabIndex = 0;
            // 
            // roomSettingsTab
            // 
            this.roomSettingsTab.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.roomSettingsTab.Controls.Add(this.tilesTab);
            this.roomSettingsTab.Controls.Add(this.objectsTab);
            this.roomSettingsTab.Location = new System.Drawing.Point(0, 0);
            this.roomSettingsTab.Margin = new System.Windows.Forms.Padding(0);
            this.roomSettingsTab.Name = "roomSettingsTab";
            this.roomSettingsTab.Padding = new System.Drawing.Point(0, 0);
            this.roomSettingsTab.SelectedIndex = 0;
            this.roomSettingsTab.Size = new System.Drawing.Size(152, 341);
            this.roomSettingsTab.TabIndex = 0;
            // 
            // tilesTab
            // 
            this.tilesTab.BackColor = System.Drawing.SystemColors.ControlLight;
            this.tilesTab.Controls.Add(this.div_left);
            this.tilesTab.Location = new System.Drawing.Point(4, 22);
            this.tilesTab.Margin = new System.Windows.Forms.Padding(0);
            this.tilesTab.Name = "tilesTab";
            this.tilesTab.Size = new System.Drawing.Size(144, 315);
            this.tilesTab.TabIndex = 0;
            this.tilesTab.Text = "Tiles";
            // 
            // div_left
            // 
            this.div_left.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.div_left.AutoScroll = true;
            this.div_left.BackColor = System.Drawing.SystemColors.Window;
            this.div_left.Controls.Add(this.tileBox);
            this.div_left.Location = new System.Drawing.Point(0, 0);
            this.div_left.Margin = new System.Windows.Forms.Padding(0);
            this.div_left.Name = "div_left";
            this.div_left.Size = new System.Drawing.Size(144, 315);
            this.div_left.TabIndex = 2;
            this.div_left.MouseClick += new System.Windows.Forms.MouseEventHandler(this.div_left_MouseClick);
            // 
            // tileBox
            // 
            this.tileBox.Location = new System.Drawing.Point(3, 182);
            this.tileBox.Name = "tileBox";
            this.tileBox.Size = new System.Drawing.Size(0, 0);
            this.tileBox.TabIndex = 2;
            this.tileBox.TabStop = false;
            this.tileBox.MouseDown += new System.Windows.Forms.MouseEventHandler(this.div_left_MouseClick);
            this.tileBox.MouseMove += new System.Windows.Forms.MouseEventHandler(this.pb_MouseMove);
            this.tileBox.MouseUp += new System.Windows.Forms.MouseEventHandler(this.div_left_MouseClick);
            // 
            // objectsTab
            // 
            this.objectsTab.Location = new System.Drawing.Point(4, 22);
            this.objectsTab.Name = "objectsTab";
            this.objectsTab.Padding = new System.Windows.Forms.Padding(3);
            this.objectsTab.Size = new System.Drawing.Size(144, 315);
            this.objectsTab.TabIndex = 1;
            this.objectsTab.Text = "Objects";
            this.objectsTab.UseVisualStyleBackColor = true;
            // 
            // resourcesTabs
            // 
            this.resourcesTabs.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.resourcesTabs.Controls.Add(this.roomsTab);
            this.resourcesTabs.Controls.Add(this.tabPage4);
            this.resourcesTabs.Location = new System.Drawing.Point(0, 0);
            this.resourcesTabs.Name = "resourcesTabs";
            this.resourcesTabs.SelectedIndex = 0;
            this.resourcesTabs.Size = new System.Drawing.Size(161, 341);
            this.resourcesTabs.TabIndex = 0;
            // 
            // roomsTab
            // 
            this.roomsTab.BackColor = System.Drawing.Color.Transparent;
            this.roomsTab.Controls.Add(this.roomsList);
            this.roomsTab.Controls.Add(this.treeView1);
            this.roomsTab.Location = new System.Drawing.Point(4, 22);
            this.roomsTab.Margin = new System.Windows.Forms.Padding(0);
            this.roomsTab.Name = "roomsTab";
            this.roomsTab.Size = new System.Drawing.Size(153, 315);
            this.roomsTab.TabIndex = 0;
            this.roomsTab.Text = "Rooms";
            // 
            // roomsList
            // 
            this.roomsList.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.roomsList.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.roomsList.FormattingEnabled = true;
            this.roomsList.Location = new System.Drawing.Point(-1, 3);
            this.roomsList.Margin = new System.Windows.Forms.Padding(0);
            this.roomsList.Name = "roomsList";
            this.roomsList.Size = new System.Drawing.Size(149, 312);
            this.roomsList.TabIndex = 1;
            this.roomsList.MouseDoubleClick += new System.Windows.Forms.MouseEventHandler(this.roomsList_MouseDoubleClick);
            // 
            // treeView1
            // 
            this.treeView1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.treeView1.Location = new System.Drawing.Point(-1, -1);
            this.treeView1.Name = "treeView1";
            this.treeView1.Size = new System.Drawing.Size(149, 317);
            this.treeView1.TabIndex = 0;
            // 
            // tabPage4
            // 
            this.tabPage4.BackColor = System.Drawing.Color.Transparent;
            this.tabPage4.Location = new System.Drawing.Point(4, 22);
            this.tabPage4.Name = "tabPage4";
            this.tabPage4.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage4.Size = new System.Drawing.Size(153, 315);
            this.tabPage4.TabIndex = 1;
            this.tabPage4.Text = "tabPage4";
            // 
            // menuBar
            // 
            this.menuBar.BackColor = System.Drawing.SystemColors.Control;
            this.menuBar.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.editToolStripMenuItem,
            this.viewToolStripMenuItem,
            this.modeToolStripMenuItem,
            this.drawToolStripMenuItem,
            this.scaleToolStripMenuItem,
            this.toolsToolStripMenuItem,
            this.gameToolStripMenuItem,
            this.helpToolStripMenuItem});
            this.menuBar.Location = new System.Drawing.Point(0, 0);
            this.menuBar.Name = "menuBar";
            this.menuBar.Size = new System.Drawing.Size(904, 24);
            this.menuBar.TabIndex = 0;
            this.menuBar.Text = "menuStrip1";
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.newProjectToolStripMenuItem,
            this.openProjectToolStripMenuItem,
            this.saveProjectToolStripMenuItem,
            this.closeProjectToolStripMenuItem,
            this.toolStripMenuItem1,
            this.exitMapEditorToolStripMenuItem});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.fileToolStripMenuItem.Text = "File";
            // 
            // newProjectToolStripMenuItem
            // 
            this.newProjectToolStripMenuItem.Name = "newProjectToolStripMenuItem";
            this.newProjectToolStripMenuItem.Size = new System.Drawing.Size(153, 22);
            this.newProjectToolStripMenuItem.Text = "New Project...";
            this.newProjectToolStripMenuItem.Click += new System.EventHandler(this.newProjectToolStripMenuItem_Click);
            // 
            // openProjectToolStripMenuItem
            // 
            this.openProjectToolStripMenuItem.Name = "openProjectToolStripMenuItem";
            this.openProjectToolStripMenuItem.Size = new System.Drawing.Size(153, 22);
            this.openProjectToolStripMenuItem.Text = "Open Project...";
            this.openProjectToolStripMenuItem.Click += new System.EventHandler(this.openProjectToolStripMenuItem_Click);
            // 
            // saveProjectToolStripMenuItem
            // 
            this.saveProjectToolStripMenuItem.Name = "saveProjectToolStripMenuItem";
            this.saveProjectToolStripMenuItem.Size = new System.Drawing.Size(153, 22);
            this.saveProjectToolStripMenuItem.Text = "Save Project";
            this.saveProjectToolStripMenuItem.Click += new System.EventHandler(this.saveProjectToolStripMenuItem_Click);
            // 
            // closeProjectToolStripMenuItem
            // 
            this.closeProjectToolStripMenuItem.Name = "closeProjectToolStripMenuItem";
            this.closeProjectToolStripMenuItem.Size = new System.Drawing.Size(153, 22);
            this.closeProjectToolStripMenuItem.Text = "Close Project";
            this.closeProjectToolStripMenuItem.Click += new System.EventHandler(this.closeProjectToolStripMenuItem_Click);
            // 
            // toolStripMenuItem1
            // 
            this.toolStripMenuItem1.Name = "toolStripMenuItem1";
            this.toolStripMenuItem1.Size = new System.Drawing.Size(150, 6);
            // 
            // exitMapEditorToolStripMenuItem
            // 
            this.exitMapEditorToolStripMenuItem.Name = "exitMapEditorToolStripMenuItem";
            this.exitMapEditorToolStripMenuItem.Size = new System.Drawing.Size(153, 22);
            this.exitMapEditorToolStripMenuItem.Text = "Exit Map Editor";
            this.exitMapEditorToolStripMenuItem.Click += new System.EventHandler(this.exitMapEditorToolStripMenuItem_Click);
            // 
            // editToolStripMenuItem
            // 
            this.editToolStripMenuItem.Name = "editToolStripMenuItem";
            this.editToolStripMenuItem.Size = new System.Drawing.Size(39, 20);
            this.editToolStripMenuItem.Text = "Edit";
            // 
            // viewToolStripMenuItem
            // 
            this.viewToolStripMenuItem.Name = "viewToolStripMenuItem";
            this.viewToolStripMenuItem.Size = new System.Drawing.Size(44, 20);
            this.viewToolStripMenuItem.Text = "View";
            // 
            // modeToolStripMenuItem
            // 
            this.modeToolStripMenuItem.Name = "modeToolStripMenuItem";
            this.modeToolStripMenuItem.Size = new System.Drawing.Size(50, 20);
            this.modeToolStripMenuItem.Text = "Mode";
            // 
            // drawToolStripMenuItem
            // 
            this.drawToolStripMenuItem.Name = "drawToolStripMenuItem";
            this.drawToolStripMenuItem.Size = new System.Drawing.Size(46, 20);
            this.drawToolStripMenuItem.Text = "Draw";
            // 
            // scaleToolStripMenuItem
            // 
            this.scaleToolStripMenuItem.Name = "scaleToolStripMenuItem";
            this.scaleToolStripMenuItem.Size = new System.Drawing.Size(46, 20);
            this.scaleToolStripMenuItem.Text = "Scale";
            // 
            // toolsToolStripMenuItem
            // 
            this.toolsToolStripMenuItem.Name = "toolsToolStripMenuItem";
            this.toolsToolStripMenuItem.Size = new System.Drawing.Size(48, 20);
            this.toolsToolStripMenuItem.Text = "Tools";
            // 
            // gameToolStripMenuItem
            // 
            this.gameToolStripMenuItem.Name = "gameToolStripMenuItem";
            this.gameToolStripMenuItem.Size = new System.Drawing.Size(50, 20);
            this.gameToolStripMenuItem.Text = "Game";
            // 
            // helpToolStripMenuItem
            // 
            this.helpToolStripMenuItem.Name = "helpToolStripMenuItem";
            this.helpToolStripMenuItem.Size = new System.Drawing.Size(44, 20);
            this.helpToolStripMenuItem.Text = "Help";
            // 
            // statusBar
            // 
            this.statusBar.GripMargin = new System.Windows.Forms.Padding(0);
            this.statusBar.Location = new System.Drawing.Point(0, 388);
            this.statusBar.Name = "statusBar";
            this.statusBar.Size = new System.Drawing.Size(904, 22);
            this.statusBar.TabIndex = 2;
            this.statusBar.Text = "statusStrip1";
            // 
            // mapBox
            // 
            this.mapBox.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.mapBox.Location = new System.Drawing.Point(3, 184);
            this.mapBox.Name = "mapBox";
            this.mapBox.Size = new System.Drawing.Size(0, 0);
            this.mapBox.TabIndex = 3;
            this.mapBox.TabStop = false;
            this.mapBox.Click += new System.EventHandler(this.mapBox_Click);
            this.mapBox.Paint += new System.Windows.Forms.PaintEventHandler(this.mapBox_Paint);
            this.mapBox.MouseMove += new System.Windows.Forms.MouseEventHandler(this.mapBox_MouseMove);
            // 
            // div_center
            // 
            this.div_center.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.div_center.AutoScroll = true;
            this.div_center.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.div_center.Controls.Add(this.mapBox);
            this.div_center.Location = new System.Drawing.Point(0, 0);
            this.div_center.Name = "div_center";
            this.div_center.Size = new System.Drawing.Size(595, 339);
            this.div_center.TabIndex = 3;
            // 
            // MainWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(904, 410);
            this.Controls.Add(this.splitContainer1);
            this.Controls.Add(this.statusBar);
            this.Controls.Add(this.toolBar);
            this.Controls.Add(this.menuBar);
            this.MainMenuStrip = this.menuBar;
            this.Name = "MainWindow";
            this.Text = "MainWindow";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.toolBar.ResumeLayout(false);
            this.toolBar.PerformLayout();
            this.splitContainer1.Panel1.ResumeLayout(false);
            this.splitContainer1.Panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).EndInit();
            this.splitContainer1.ResumeLayout(false);
            this.splitContainer2.Panel1.ResumeLayout(false);
            this.splitContainer2.Panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer2)).EndInit();
            this.splitContainer2.ResumeLayout(false);
            this.roomSettingsTab.ResumeLayout(false);
            this.tilesTab.ResumeLayout(false);
            this.div_left.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.tileBox)).EndInit();
            this.resourcesTabs.ResumeLayout(false);
            this.roomsTab.ResumeLayout(false);
            this.menuBar.ResumeLayout(false);
            this.menuBar.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.mapBox)).EndInit();
            this.div_center.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ToolStrip toolBar;
        private System.Windows.Forms.SplitContainer splitContainer1;
        private System.Windows.Forms.SplitContainer splitContainer2;
        private System.Windows.Forms.ToolStripButton toolStripButton1;
        private System.Windows.Forms.TabControl roomSettingsTab;
        private System.Windows.Forms.TabPage tilesTab;
        private System.Windows.Forms.TabPage objectsTab;
        private System.Windows.Forms.TabControl resourcesTabs;
        private System.Windows.Forms.TabPage roomsTab;
        private System.Windows.Forms.TabPage tabPage4;
        private System.Windows.Forms.TreeView treeView1;
        private System.Windows.Forms.MenuStrip menuBar;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem editToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem viewToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem modeToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem drawToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem scaleToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem toolsToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem gameToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem helpToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem newProjectToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem openProjectToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem saveProjectToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem closeProjectToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem exitMapEditorToolStripMenuItem;
        private System.Windows.Forms.ToolStripButton toolStripButton2;
        private System.Windows.Forms.ToolStripButton toolStripButton3;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator1;
        private System.Windows.Forms.Panel div_left;
        private System.Windows.Forms.PictureBox tileBox;
        private System.Windows.Forms.StatusStrip statusBar;
        private System.Windows.Forms.ToolStripButton toggleProjectFiles;
        private System.Windows.Forms.ListBox roomsList;
        private System.Windows.Forms.Panel div_center;
        private System.Windows.Forms.PictureBox mapBox;

    }
}