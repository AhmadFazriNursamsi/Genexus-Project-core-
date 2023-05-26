package com.kbbaru.general.security ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.general.security.notauthorized", "/com.kbbaru.general.security.notauthorized"})
public final  class notauthorized extends GXWebObjectStub
{
   public notauthorized( )
   {
   }

   public notauthorized( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( notauthorized.class ));
   }

   public notauthorized( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new notauthorized_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new notauthorized_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Not Authorized web panel";
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

