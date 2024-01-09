package com.client.employ.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.client.designSystem.icon.EmployIcons
import com.client.employ.R
import com.client.employ.feature.dashboard.R as dashboard

enum class TabsDestinations(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int
) {
    Dashboard(
        selectedIcon = EmployIcons.Dashboard,
        unselectedIcon = EmployIcons.DashboardUnselected,
        iconTextId = dashboard.string.feature_dashboard_title,
        titleTextId = dashboard.string.feature_dashboard_title
    ),
    SAVED_JOBS(
        selectedIcon = EmployIcons.Saved_jobs,
        unselectedIcon = EmployIcons.Saved_jobsUnselected,
        iconTextId = R.string.saved_jobs,
        titleTextId = R.string.saved_jobs,
    ),
    PROFILE(
        selectedIcon = EmployIcons.Profile,
        unselectedIcon = EmployIcons.ProfileUnselected,
        iconTextId = R.string.profile,
        titleTextId = R.string.profile
    ),
    APPLICATIONS(
        selectedIcon = EmployIcons.Applications,
        unselectedIcon = EmployIcons.ApplicationsUnselected,
        iconTextId = R.string.applications,
        titleTextId = R.string.applications
    ),
    MESSAGE(
        selectedIcon = EmployIcons.Message,
        unselectedIcon = EmployIcons.MessageUnselected,
        iconTextId = R.string.message,
        titleTextId = R.string.message
    ),
}
