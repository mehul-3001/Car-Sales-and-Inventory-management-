const resizeColumns = (
  params: GridSizeChangedEvent | FirstDataRenderedEvent
): void => {
  const gridDiv = document.querySelector(
    '.ag-body-viewport'
  ) as HTMLElement | null;

  if (!gridDiv) return;

  const gridWidth = gridDiv.clientWidth;

  const totalColumnWidth = params.columnApi
    .getAllDisplayedColumns()
    .reduce((sum, col) => sum + col.getActualWidth(), 0);

  totalColumnWidth > gridWidth
    ? params.columnApi.autoSizeAllColumns(false)
    : params.api.sizeColumnsToFit();
};
