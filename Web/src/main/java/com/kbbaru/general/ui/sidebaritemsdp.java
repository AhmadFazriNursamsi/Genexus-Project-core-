package com.kbbaru.general.ui ;
import com.kbbaru.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sidebaritemsdp extends GXProcedure
{
   public sidebaritemsdp( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sidebaritemsdp.class ), "" );
   }

   public sidebaritemsdp( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.unanimo.genexusunanimo.SdtSidebarItems_SidebarItem> executeUdp( )
   {
      sidebaritemsdp.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.unanimo.genexusunanimo.SdtSidebarItems_SidebarItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.unanimo.genexusunanimo.SdtSidebarItems_SidebarItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.unanimo.genexusunanimo.SdtSidebarItems_SidebarItem>[] aP0 )
   {
      sidebaritemsdp.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_objcol_SdtProgramNames_ProgramName1 = AV5wwProgramNames ;
      GXv_objcol_SdtProgramNames_ProgramName2[0] = GXt_objcol_SdtProgramNames_ProgramName1 ;
      new com.kbbaru.general.ui.listprograms(remoteHandle, context).execute( GXv_objcol_SdtProgramNames_ProgramName2) ;
      GXt_objcol_SdtProgramNames_ProgramName1 = GXv_objcol_SdtProgramNames_ProgramName2[0] ;
      AV5wwProgramNames = GXt_objcol_SdtProgramNames_ProgramName1 ;
      AV11GXV1 = 1 ;
      while ( AV11GXV1 <= AV5wwProgramNames.size() )
      {
         AV6wwProgramName = (com.kbbaru.general.ui.SdtProgramNames_ProgramName)((com.kbbaru.general.ui.SdtProgramNames_ProgramName)AV5wwProgramNames.elementAt(-1+AV11GXV1));
         Gxm1sidebaritems = (com.unanimo.genexusunanimo.SdtSidebarItems_SidebarItem)new com.unanimo.genexusunanimo.SdtSidebarItems_SidebarItem(remoteHandle, context);
         Gxm2rootcol.add(Gxm1sidebaritems, 0);
         Gxm1sidebaritems.setgxTv_SdtSidebarItems_SidebarItem_Id( AV6wwProgramName.getgxTv_SdtProgramNames_ProgramName_Name() );
         Gxm1sidebaritems.setgxTv_SdtSidebarItems_SidebarItem_Title( AV6wwProgramName.getgxTv_SdtProgramNames_ProgramName_Description() );
         Gxm1sidebaritems.setgxTv_SdtSidebarItems_SidebarItem_Target( AV6wwProgramName.getgxTv_SdtProgramNames_ProgramName_Link() );
         Gxm1sidebaritems.setgxTv_SdtSidebarItems_SidebarItem_Hassubitems( false );
         AV11GXV1 = (int)(AV11GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = sidebaritemsdp.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.unanimo.genexusunanimo.SdtSidebarItems_SidebarItem>(com.unanimo.genexusunanimo.SdtSidebarItems_SidebarItem.class, "SidebarItem", "GeneXusUnanimo", remoteHandle);
      AV5wwProgramNames = new GXBaseCollection<com.kbbaru.general.ui.SdtProgramNames_ProgramName>(com.kbbaru.general.ui.SdtProgramNames_ProgramName.class, "ProgramName", "KBBaru", remoteHandle);
      GXt_objcol_SdtProgramNames_ProgramName1 = new GXBaseCollection<com.kbbaru.general.ui.SdtProgramNames_ProgramName>(com.kbbaru.general.ui.SdtProgramNames_ProgramName.class, "ProgramName", "KBBaru", remoteHandle);
      AV6wwProgramName = new com.kbbaru.general.ui.SdtProgramNames_ProgramName(remoteHandle, context);
      Gxm1sidebaritems = new com.unanimo.genexusunanimo.SdtSidebarItems_SidebarItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      initializeGenerics();
   }

   @SuppressWarnings("unchecked")
   private void initializeGenerics( )
   {
      GXv_objcol_SdtProgramNames_ProgramName2 = new GXBaseCollection[1] ;
   }

   private short Gx_err ;
   private int AV11GXV1 ;
   private GXBaseCollection<com.unanimo.genexusunanimo.SdtSidebarItems_SidebarItem>[] aP0 ;
   private GXBaseCollection<com.kbbaru.general.ui.SdtProgramNames_ProgramName> AV5wwProgramNames ;
   private GXBaseCollection<com.kbbaru.general.ui.SdtProgramNames_ProgramName> GXt_objcol_SdtProgramNames_ProgramName1 ;
   private GXBaseCollection<com.kbbaru.general.ui.SdtProgramNames_ProgramName> GXv_objcol_SdtProgramNames_ProgramName2[] ;
   private GXBaseCollection<com.unanimo.genexusunanimo.SdtSidebarItems_SidebarItem> Gxm2rootcol ;
   private com.kbbaru.general.ui.SdtProgramNames_ProgramName AV6wwProgramName ;
   private com.unanimo.genexusunanimo.SdtSidebarItems_SidebarItem Gxm1sidebaritems ;
}

