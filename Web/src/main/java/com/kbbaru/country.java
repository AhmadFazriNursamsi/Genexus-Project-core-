package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.country", "/com.kbbaru.country"})
public final  class country extends GXWebObjectStub
{
   public country( )
   {
   }

   public country( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( country.class ));
   }

   public country( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new country_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new country_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Country";
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

