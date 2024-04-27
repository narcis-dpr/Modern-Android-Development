package com.narcis.bigscreens.util

import androidx.window.layout.FoldingFeature
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
fun cityPosture(foldFeature: FoldingFeature?): Boolean {
    contract { returns(true) implies (foldFeature != null) }

    return foldFeature?.state == FoldingFeature.State.HALF_OPENED &&
            foldFeature.orientation == FoldingFeature.Orientation.VERTICAL
}

@OptIn(ExperimentalContracts::class)
fun separating(foldFeature: FoldingFeature?): Boolean {
    contract { returns(true) implies (foldFeature != null) }

    return foldFeature?.state == FoldingFeature.State.FLAT && foldFeature.isSeparating
}