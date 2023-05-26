package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.attractionsgeneral", "/com.kbbaru.attractionsgeneral"})
public final  class attractionsgeneral extends GXWebObjectStub
{
   public attractionsgeneral( )
   {
   }

   public attractionsgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( attractionsgeneral.class ));
   }

   public attractionsgeneral( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new attractionsgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new attractionsgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Attractions General";
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

