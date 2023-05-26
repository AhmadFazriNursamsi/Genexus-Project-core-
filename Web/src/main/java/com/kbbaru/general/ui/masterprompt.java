package com.kbbaru.general.ui ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.general.ui.masterprompt", "/com.kbbaru.general.ui.masterprompt"})
public final  class masterprompt extends GXWebObjectStub
{
   public masterprompt( )
   {
   }

   public masterprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( masterprompt.class ));
   }

   public masterprompt( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new masterprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new masterprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Prompt Master Page";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

