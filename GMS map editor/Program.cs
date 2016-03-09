using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using System.Xml;
using System.IO;
using System.Text;

namespace WindowsFormsApplication1
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            //Load Existing Project

            StringBuilder output = new StringBuilder();

            String xmlString = "<background>potato</background>";//File.ReadAllText(@"D:\Projects\GMLCoder\testProject.gmx\testProject.project.gmx").ToString();

            MessageBox.Show(xmlString);

            // Create an XmlReader
            using (XmlReader reader = XmlReader.Create(new StringReader(xmlString)))
            {
                reader.ReadToFollowing("backgrounds");
                while (reader.Read())
                {
                    if (reader.ReadElementContentAsString() != ""){
                        MessageBox.Show(reader.ReadElementContentAsString());
                    }
                }


                //reader.ReadToFollowing("title");
                //output.AppendLine("Content of the title element: " + reader.ReadElementContentAsString());

                /*while (reader.Read())
                {
                    switch (reader.NodeType)
                    {
                        case XmlNodeType.Element:
                            output.AppendLine(reader.Name);
                            break;
                        case XmlNodeType.Text:
                            output.AppendLine(reader.Value);
                            break;
                        case XmlNodeType.XmlDeclaration:
                        case XmlNodeType.ProcessingInstruction:
                            //writer.WriteProcessingInstruction(reader.Name, reader.Value);
                            break;
                        case XmlNodeType.Comment:
                            output.AppendLine(reader.Value);
                            break;
                        case XmlNodeType.EndElement:
                            //writer.WriteFullEndElement();
                            break;
                    }
                }*/
            }

            MessageBox.Show(output.ToString());

            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new InterfazBasica());
        }
    }
}
