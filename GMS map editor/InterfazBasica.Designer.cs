namespace WindowsFormsApplication1
{
    partial class InterfazBasica
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
            this.testu = new System.Windows.Forms.Button();
            this.div_left = new System.Windows.Forms.Panel();
            this.div_left.SuspendLayout();
            this.SuspendLayout();
            // 
            // testu
            // 
            this.testu.Location = new System.Drawing.Point(34, 31);
            this.testu.Name = "testu";
            this.testu.Size = new System.Drawing.Size(75, 23);
            this.testu.TabIndex = 0;
            this.testu.Text = "button1";
            this.testu.UseVisualStyleBackColor = true;
            // 
            // div_left
            // 
            this.div_left.AutoScroll = true;
            this.div_left.AutoScrollMargin = new System.Drawing.Size(12, 0);
            this.div_left.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.div_left.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.div_left.Controls.Add(this.testu);
            this.div_left.Location = new System.Drawing.Point(-1, 0);
            this.div_left.Name = "div_left";
            this.div_left.Size = new System.Drawing.Size(226, 271);
            this.div_left.TabIndex = 1;
            // 
            // InterfazBasica
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(575, 269);
            this.Controls.Add(this.div_left);
            this.Name = "InterfazBasica";
            this.Text = "InterfazBasica";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.InterfazBasica_Load);
            this.SizeChanged += new System.EventHandler(this.InterfazBasica_SizeChanged);
            this.div_left.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button testu;
        private System.Windows.Forms.Panel div_left;


    }
}